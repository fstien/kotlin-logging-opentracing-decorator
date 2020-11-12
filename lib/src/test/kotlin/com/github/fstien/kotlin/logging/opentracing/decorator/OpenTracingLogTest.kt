package com.github.fstien.kotlin.logging.opentracing.decorator

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isTrue
import com.zopa.ktor.opentracing.ThreadContextElementScopeManager
import com.zopa.ktor.opentracing.span
import com.zopa.ktor.opentracing.threadLocalSpanStack
import io.opentracing.Span
import io.opentracing.mock.MockTracer
import io.opentracing.util.GlobalTracer
import kotlinx.coroutines.asContextElement
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import mu.KLoggable
import org.junit.Before
import org.junit.Test
import java.util.Stack


class ClassHasLogging: KLoggable {
    override val logger = logger().withOpenTracingLogs()
    fun test() = span {
        logger.info { "An interesting info log." }
    }

    fun testWithException() = span {
        try {
            throw Exception("Some error occurred")
        } catch (e: Exception) {
            logger.error(e) {"Exception caught."}
        }
    }

    fun testErrorLog() = span {
        logger.error { "Something bad happened!" }
    }
}

class OpenTracingLogTest {
    private val mockTracer = MockTracer(ThreadContextElementScopeManager())

    @Before
    fun setupTracer() {
        mockTracer.reset()
        GlobalTracer.registerIfAbsent(mockTracer)
    }

    @Test
    fun `write logs with messages to active spans`() = runBlocking {
        val classHasLogging = ClassHasLogging()

        withContext(threadLocalSpanStack.asContextElement(Stack<Span>())) {
            classHasLogging.test()
            classHasLogging.testWithException()
            classHasLogging.testErrorLog()
        }

        with(mockTracer.finishedSpans()) {
            with(this[0].logEntries()[0].fields()) {
                assertThat(this["level"]).isEqualTo("Info")
                assertThat(this["message"]).isEqualTo("An interesting info log.")
            }

            with(this[1].logEntries()[0].fields()) {
                assertThat(this["level"]).isEqualTo("Error")
                assertThat(this["message"]).isEqualTo("Exception caught.")
                assertThat(this["exception"].toString()
                    .contains("java.lang.Exception: Some error occurred"))
                    .isTrue()
            }

            with(this[2].logEntries()[0].fields()) {
                assertThat(this["level"]).isEqualTo("Error")
                assertThat(this["message"]).isEqualTo("Something bad happened!")
            }

            assertThat(this[2].tags()["error"]).isEqualTo(true)
        }
    }
}
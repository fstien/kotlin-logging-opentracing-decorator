package com.github.fstien.kotlin.logging.opentracing.decorator.kotlingloggingregressiontest

import com.github.fstien.kotlin.logging.opentracing.decorator.withTraceLogs
import mu.KLoggable
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.core.Appender
import org.apache.logging.log4j.core.appender.WriterAppender
import org.apache.logging.log4j.core.config.Configurator
import org.apache.logging.log4j.core.layout.PatternLayout
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.StringWriter

open class ClassHasLogging : KLoggable {
    override val logger = logger().withTraceLogs()
    fun test() {
        logger.info { "test ClassHasLogging" }
    }
}

class CompanionHasLogging {
    companion object : Any(), KLoggable {
        override val logger = logger().withTraceLogs()
    }

    fun test() {
        logger.info { "test CompanionHasLogging" }
    }
}

data class ClassWithIncorrectToString(val someVariable: String? = null) {
    override fun toString(): String {
        return someVariable!!.toString()
    }
}

fun newPatternLayout(pattern: String): PatternLayout = PatternLayout.newBuilder().withPattern(pattern).build()

fun addAppender(appender: Appender) {
    val context = LogManager.getContext(false) as org.apache.logging.log4j.core.LoggerContext
    context.configuration.rootLogger.addAppender(appender, null, null)
    appender.start()
}

fun removeAppender(appender: Appender) {
    val context = LogManager.getContext(false) as org.apache.logging.log4j.core.LoggerContext
    context.configuration.rootLogger.removeAppender(appender.name)
    appender.stop()
}

class LoggingTest {
    private val appenderWithWriter: AppenderWithWriter = AppenderWithWriter()

    init {
        Configurator.setRootLevel(Level.TRACE)
    }

    @Before
    fun setupAppender() {
        addAppender(appenderWithWriter.appender)
    }

    @After
    fun removeAppender() {
        removeAppender(appenderWithWriter.appender)
    }

    @Test
    fun testMessages5() {
        ClassHasLogging().test()
        appenderWithWriter.writer.flush()
        Assert.assertEquals(
            "INFO  com.github.fstien.kotlin.logging.opentracing.decorator.kotlingloggingregressiontest.ClassHasLogging  - test ClassHasLogging", appenderWithWriter.writer.toString().trim()
        )
    }

    @Test
    fun testMessages6() {
        CompanionHasLogging().test()
        appenderWithWriter.writer.flush()
        Assert.assertEquals(
            "INFO  com.github.fstien.kotlin.logging.opentracing.decorator.kotlingloggingregressiontest.CompanionHasLogging  - test CompanionHasLogging", appenderWithWriter.writer.toString().trim()
        )
    }

    @Test
    fun `check underlyingLogger property`() {
        Assert.assertEquals("com.github.fstien.kotlin.logging.opentracing.decorator.kotlingloggingregressiontest.ClassHasLogging", ClassHasLogging().logger.underlyingLogger.name)
    }
}


data class AppenderWithWriter(
    val pattern: String = "%-5p %c %marker - %m%n",
    val writer: StringWriter = StringWriter(),
    val appender: Appender = WriterAppender.createAppender(
        newPatternLayout(pattern), null, writer, "writer", false, true
    )
)

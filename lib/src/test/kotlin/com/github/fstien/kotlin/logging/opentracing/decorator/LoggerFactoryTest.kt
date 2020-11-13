package com.github.fstien.kotlin.logging.opentracing.decorator

import org.junit.Assert.assertEquals
import org.junit.Test

private val loggerFunc = Logging.logger {}
private val loggerName = Logging.logger("testLogger")

class ForKotlinLoggingTest {
    val loggerInClassFunc = Logging.logger { }
    val loggerInClassName = Logging.logger("ForKotlinLoggingTest")

    companion object {
        val loggerInCompanionFunc = Logging.logger { }
        val loggerInCompanionName = Logging.logger("ForKotlinLoggingTest")
    }
}

class LoggerFactoryTest {
    @Test
    fun `test logger name using passed func`() {
        assertEquals("com.github.fstien.kotlin.logging.opentracing.decorator.LoggerFactoryTest", loggerFunc.name)
        assertEquals("com.github.fstien.kotlin.logging.opentracing.decorator.ForKotlinLoggingTest", ForKotlinLoggingTest().loggerInClassFunc.name)
        assertEquals("com.github.fstien.kotlin.logging.opentracing.decorator.ForKotlinLoggingTest", ForKotlinLoggingTest.loggerInCompanionFunc.name)
    }

    @Test
    fun `test logger name using passed name`() {
        assertEquals("testLogger", loggerName.name)
        assertEquals("ForKotlinLoggingTest", ForKotlinLoggingTest().loggerInClassName.name)
        assertEquals("ForKotlinLoggingTest", ForKotlinLoggingTest.loggerInCompanionName.name)
    }
}

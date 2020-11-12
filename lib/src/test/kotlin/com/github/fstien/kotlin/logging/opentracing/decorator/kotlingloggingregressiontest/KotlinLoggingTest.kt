package com.github.fstien.kotlin.logging.opentracing.decorator.kotlingloggingregressiontest

import com.github.fstien.kotlin.logging.opentracing.decorator.withTraceLogs
import mu.KotlinLogging
import mu.toKLogger
import org.junit.Assert.assertEquals
import org.junit.Test
import org.slf4j.LoggerFactory

private val logger = KotlinLogging.logger { }.withTraceLogs()
private val loggerFromSlf4j = KotlinLogging.logger(LoggerFactory.getLogger("mu.slf4jLogger")).withTraceLogs()
private val loggerFromSlf4jExtension = LoggerFactory.getLogger("mu.slf4jLoggerExtension").toKLogger().withTraceLogs()

class ForKotlinLoggingTest {
    val loggerInClass = KotlinLogging.logger { }.withTraceLogs()

    companion object {
        val loggerInCompanion = KotlinLogging.logger { }.withTraceLogs()
    }
}

class KotlinLoggingTest {

    @Test
    fun testLoggerName() {
        assertEquals("com.github.fstien.kotlin.logging.opentracing.decorator.kotlingloggingregressiontest.KotlinLoggingTest", logger.name)
        assertEquals("com.github.fstien.kotlin.logging.opentracing.decorator.kotlingloggingregressiontest.ForKotlinLoggingTest", ForKotlinLoggingTest().loggerInClass.name)
        assertEquals("com.github.fstien.kotlin.logging.opentracing.decorator.kotlingloggingregressiontest.ForKotlinLoggingTest", ForKotlinLoggingTest.loggerInCompanion.name)
        assertEquals("mu.slf4jLogger", loggerFromSlf4j.name)
        assertEquals("mu.slf4jLoggerExtension", loggerFromSlf4jExtension.name)
    }
}

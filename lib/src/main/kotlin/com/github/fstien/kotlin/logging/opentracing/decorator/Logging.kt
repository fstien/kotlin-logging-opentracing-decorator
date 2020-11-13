package com.github.fstien.kotlin.logging.opentracing.decorator

import mu.KLogger
import mu.KotlinLogging

object Logging {
    fun logger(func: () -> Unit): KLogger = KLoggerOpenTracingDecorator(KotlinLogging.logger(func))
    fun logger(name: String): KLogger = KLoggerOpenTracingDecorator(KotlinLogging.logger(name))
}

fun KLogger.withOpenTracingLogs(): KLogger = KLoggerOpenTracingDecorator(this)

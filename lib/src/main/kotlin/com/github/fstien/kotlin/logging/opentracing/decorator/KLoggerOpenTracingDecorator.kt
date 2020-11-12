package com.github.fstien.kotlin.logging.opentracing.decorator

import mu.KLogger
import org.slf4j.Marker
import org.slf4j.Logger


fun KLogger.withTraceLogs(): KLogger = KLoggerOpenTracingDecorator(this)

internal class KLoggerOpenTracingDecorator(private val kLogger: KLogger) : KLogger {
    override val underlyingLogger: Logger
        get() = kLogger

    override fun <T : Throwable> catching(throwable: T) {
        kLogger.catching(throwable)
        kLogger.tracerLog(t = throwable)
    }

    override fun debug(msg: () -> Any?) {
        kLogger.debug(msg)
        kLogger.tracerLog(LEVEL.Debug, msg.toStringSafe())
    }

    override fun debug(t: Throwable?, msg: () -> Any?) {
        kLogger.debug(t, msg)
        kLogger.tracerLog(LEVEL.Debug, msg.toStringSafe(), t)
    }

    override fun debug(marker: Marker?, msg: () -> Any?) {
        kLogger.debug(marker, msg)
        kLogger.tracerLog(LEVEL.Debug, msg.toStringSafe())
    }

    override fun debug(marker: Marker?, t: Throwable?, msg: () -> Any?) {
        kLogger.debug(marker, t, msg)
        kLogger.tracerLog(LEVEL.Debug, msg.toStringSafe(), t)
    }

    override fun debug(msg: String?) {
        kLogger.debug(msg)
        kLogger.tracerLog(LEVEL.Debug, msg)
    }

    override fun debug(format: String?, arg: Any?) {
        kLogger.debug(format, arg)
    }

    override fun debug(format: String?, arg1: Any?, arg2: Any?) {
        kLogger.debug(format, arg1, arg2)
    }

    override fun debug(format: String?, vararg arguments: Any?) {
        kLogger.debug(format, arguments)
    }

    override fun debug(msg: String?, t: Throwable?) {
        kLogger.debug(msg, t)
        kLogger.tracerLog(LEVEL.Debug, msg, t)
    }

    override fun debug(marker: Marker?, msg: String?) {
        kLogger.debug(marker, msg)
        kLogger.tracerLog(LEVEL.Debug, msg)
    }

    override fun debug(marker: Marker?, format: String?, arg: Any?) {
        kLogger.debug(marker, format, arg)
    }

    override fun debug(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        kLogger.debug(marker, format, arg1, arg2)
    }

    override fun debug(marker: Marker?, format: String?, vararg arguments: Any?) {
        kLogger.debug(marker, format, arguments)
    }

    override fun debug(marker: Marker?, msg: String?, t: Throwable?) {
        kLogger.debug(marker, msg, t)
        kLogger.tracerLog(LEVEL.Debug, msg, t)
    }

    override fun entry(vararg argArray: Any?) {
        kLogger.entry(argArray)
    }

    override fun error(msg: () -> Any?) {
        kLogger.error(msg)
        kLogger.tracerLog(LEVEL.Error, msg.toStringSafe())
    }

    override fun error(t: Throwable?, msg: () -> Any?) {
        kLogger.error(t, msg)
        kLogger.tracerLog(LEVEL.Error, msg.toStringSafe(), t)
    }

    override fun error(marker: Marker?, msg: () -> Any?) {
        kLogger.error(marker, msg)
        kLogger.tracerLog(LEVEL.Error, msg.toStringSafe())
    }

    override fun error(marker: Marker?, t: Throwable?, msg: () -> Any?) {
        kLogger.error(marker, t, msg)
        kLogger.tracerLog(LEVEL.Error, msg.toStringSafe(), t)
    }

    override fun error(msg: String?) {
        kLogger.error(msg)
        kLogger.tracerLog(LEVEL.Error, msg)
    }

    override fun error(format: String?, arg: Any?) {
        kLogger.error(format)
    }

    override fun error(format: String?, arg1: Any?, arg2: Any?) {
        kLogger.error(format, arg1, arg2)
    }

    override fun error(format: String?, vararg arguments: Any?) {
        kLogger.error(format, arguments)
    }

    override fun error(msg: String?, t: Throwable?) {
        kLogger.error(msg, t)
        kLogger.tracerLog(LEVEL.Error, msg, t)
    }

    override fun error(marker: Marker?, msg: String?) {
        kLogger.error(marker, msg)
        kLogger.tracerLog(LEVEL.Error, msg)
    }

    override fun error(marker: Marker?, format: String?, arg: Any?) {
        kLogger.error(marker, format, arg)
    }

    override fun error(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        kLogger.error(marker, format, arg1, arg2)
    }

    override fun error(marker: Marker?, format: String?, vararg arguments: Any?) {
        kLogger.error(marker, format, arguments)
    }

    override fun error(marker: Marker?, msg: String?, t: Throwable?) {
        kLogger.error(marker, msg, t)
        kLogger.tracerLog(LEVEL.Error, msg, t)
    }

    override fun exit() {
        kLogger.exit()
    }

    override fun <T> exit(result: T): T {
        return kLogger.exit(result)
    }

    override fun getName(): String {
        return kLogger.name
    }

    override fun info(msg: () -> Any?) {
        kLogger.info(msg)
        kLogger.tracerLog(LEVEL.Info, msg.toStringSafe())
    }

    override fun info(t: Throwable?, msg: () -> Any?) {
        kLogger.info(t, msg)
        kLogger.tracerLog(LEVEL.Info, msg.toStringSafe(), t)
    }

    override fun info(marker: Marker?, msg: () -> Any?) {
        kLogger.info(marker, msg)
        kLogger.tracerLog(LEVEL.Info, msg.toStringSafe())
    }

    override fun info(marker: Marker?, t: Throwable?, msg: () -> Any?) {
        kLogger.info(marker, t, msg)
        kLogger.tracerLog(LEVEL.Info, msg.toStringSafe(), t)
    }

    override fun info(msg: String?) {
        kLogger.info(msg)
        kLogger.tracerLog(LEVEL.Info, msg)
    }

    override fun info(format: String?, arg: Any?) {
        kLogger.info(format, arg)
    }

    override fun info(format: String?, arg1: Any?, arg2: Any?) {
        kLogger.info(format, arg1, arg2)
    }

    override fun info(format: String?, vararg arguments: Any?) {
        kLogger.info(format, arguments)
    }

    override fun info(msg: String?, t: Throwable?) {
        kLogger.info(msg, t)
        kLogger.tracerLog(LEVEL.Info, msg, t)
    }

    override fun info(marker: Marker?, msg: String?) {
        kLogger.info(marker, msg)
        kLogger.tracerLog(LEVEL.Info, msg)
    }

    override fun info(marker: Marker?, format: String?, arg: Any?) {
        kLogger.info(marker, format, arg)
    }

    override fun info(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        kLogger.info(marker, format, arg1, arg2)
    }

    override fun info(marker: Marker?, format: String?, vararg arguments: Any?) {
        kLogger.info(marker, format, arguments)
    }

    override fun info(marker: Marker?, msg: String?, t: Throwable?) {
        kLogger.info(marker, msg, t)
        kLogger.tracerLog(LEVEL.Info, msg, t)
    }

    override fun isDebugEnabled(): Boolean {
        return kLogger.isDebugEnabled
    }

    override fun isDebugEnabled(marker: Marker?): Boolean {
        return kLogger.isDebugEnabled(marker)
    }

    override fun isErrorEnabled(): Boolean {
        return kLogger.isErrorEnabled
    }

    override fun isErrorEnabled(marker: Marker?): Boolean {
        return kLogger.isErrorEnabled(marker)
    }

    override fun isInfoEnabled(): Boolean {
        return kLogger.isInfoEnabled
    }

    override fun isInfoEnabled(marker: Marker?): Boolean {
        return kLogger.isInfoEnabled(marker)
    }

    override fun isTraceEnabled(): Boolean {
        return kLogger.isTraceEnabled
    }

    override fun isTraceEnabled(marker: Marker?): Boolean {
        return kLogger.isTraceEnabled(marker)
    }

    override fun isWarnEnabled(): Boolean {
        return kLogger.isWarnEnabled
    }

    override fun isWarnEnabled(marker: Marker?): Boolean {
        return kLogger.isWarnEnabled(marker)
    }

    override fun <T : Throwable> throwing(throwable: T): T {
        return kLogger.throwing(throwable)
    }

    override fun trace(msg: () -> Any?) {
        kLogger.trace(msg)
        kLogger.tracerLog(LEVEL.Trace, msg.toStringSafe())
    }

    override fun trace(t: Throwable?, msg: () -> Any?) {
        kLogger.trace(t, msg)
        kLogger.tracerLog(LEVEL.Trace, msg.toStringSafe(), t)
    }

    override fun trace(marker: Marker?, msg: () -> Any?) {
        kLogger.trace(marker, msg)
        kLogger.tracerLog(LEVEL.Trace, msg.toStringSafe())
    }

    override fun trace(marker: Marker?, t: Throwable?, msg: () -> Any?) {
        kLogger.trace(marker, t, msg)
        kLogger.tracerLog(LEVEL.Trace, msg.toStringSafe(), t)
    }

    override fun trace(msg: String?) {
        kLogger.trace(msg)
        kLogger.tracerLog(LEVEL.Trace, msg)
    }

    override fun trace(format: String?, arg: Any?) {
        kLogger.trace(format, arg)
    }

    override fun trace(format: String?, arg1: Any?, arg2: Any?) {
        kLogger.trace(format, arg1, arg2)
    }

    override fun trace(format: String?, vararg arguments: Any?) {
        kLogger.trace(format, arguments)
    }

    override fun trace(msg: String?, t: Throwable?) {
        kLogger.trace(msg, t)
        kLogger.tracerLog(LEVEL.Trace, msg, t)
    }

    override fun trace(marker: Marker?, msg: String?) {
        kLogger.trace(marker, msg)
        kLogger.tracerLog(LEVEL.Trace, msg)
    }

    override fun trace(marker: Marker?, format: String?, arg: Any?) {
        kLogger.trace(marker, format, arg)
    }

    override fun trace(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        kLogger.trace(marker, format, arg1, arg2)
    }

    override fun trace(marker: Marker?, format: String?, vararg argArray: Any?) {
        kLogger.trace(marker, format, argArray)
    }

    override fun trace(marker: Marker?, msg: String?, t: Throwable?) {
        kLogger.trace(marker, msg, t)
        kLogger.tracerLog(LEVEL.Trace, msg, t)
    }

    override fun warn(msg: () -> Any?) {
        kLogger.warn(msg)
        kLogger.tracerLog(LEVEL.Warn, msg.toStringSafe())
    }

    override fun warn(t: Throwable?, msg: () -> Any?) {
        kLogger.warn(t, msg)
        kLogger.tracerLog(LEVEL.Warn, msg.toStringSafe(), t)
    }

    override fun warn(marker: Marker?, msg: () -> Any?) {
        kLogger.warn(marker, msg)
        kLogger.tracerLog(LEVEL.Warn, msg.toStringSafe())
    }

    override fun warn(marker: Marker?, t: Throwable?, msg: () -> Any?) {
        kLogger.warn(marker, t, msg)
        kLogger.tracerLog(LEVEL.Warn, msg.toStringSafe(), t)
    }

    override fun warn(msg: String?) {
        kLogger.warn(msg)
        kLogger.tracerLog(LEVEL.Warn, msg)
    }

    override fun warn(format: String?, arg: Any?) {
        kLogger.warn(format, arg)
    }

    override fun warn(format: String?, vararg arguments: Any?) {
        kLogger.warn(format, arguments)
    }

    override fun warn(format: String?, arg1: Any?, arg2: Any?) {
        kLogger.warn(format, arg1, arg2)
    }

    override fun warn(msg: String?, t: Throwable?) {
        kLogger.warn(msg, t)
        kLogger.tracerLog(LEVEL.Warn, msg, t)
    }

    override fun warn(marker: Marker?, msg: String?) {
        kLogger.warn(marker, msg)
        kLogger.tracerLog(LEVEL.Warn, msg)
    }

    override fun warn(marker: Marker?, format: String?, arg: Any?) {
        kLogger.warn(marker, format, arg)
    }

    override fun warn(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        kLogger.warn(marker, format, arg1, arg2)
    }

    override fun warn(marker: Marker?, format: String?, vararg arguments: Any?) {
        kLogger.warn(marker, format, arguments)
    }

    override fun warn(marker: Marker?, msg: String?, t: Throwable?) {
        kLogger.warn(marker, msg, t)
        kLogger.tracerLog(LEVEL.Warn, msg, t)
    }
}
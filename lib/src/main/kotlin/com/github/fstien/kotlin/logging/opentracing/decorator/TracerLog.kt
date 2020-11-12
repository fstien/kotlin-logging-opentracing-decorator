package com.github.fstien.kotlin.logging.opentracing.decorator

import io.opentracing.util.GlobalTracer
import mu.KLogger
import java.io.PrintWriter
import java.io.StringWriter


internal enum class LEVEL { Trace, Debug, Info, Warn, Error }

internal fun KLogger.tracerLog(
        level: LEVEL? = null,
        message: String? = null,
        t: Throwable? = null) {

    val activeSpan = GlobalTracer.get()?.activeSpan() ?: return

    val fields = mutableMapOf<String, String>()
    if (level != null) fields["level"] = level.toString()
    if (message != null) fields["message"] = message
    if (t != null) fields["exception"] = t.toStackTrace()

    when (level) {
        LEVEL.Trace -> if (this.isInfoEnabled) activeSpan.log(fields)
        LEVEL.Debug -> if (this.isDebugEnabled) activeSpan.log(fields)
        LEVEL.Info -> if (this.isInfoEnabled) activeSpan.log(fields)
        LEVEL.Warn -> if (this.isWarnEnabled) activeSpan.log(fields)
        LEVEL.Error -> if (this.isErrorEnabled) {
            activeSpan.log(fields)
            activeSpan.setTag("error", true)
        }
    }
}

internal fun Throwable.toStackTrace(): String {
    val trace = StringWriter()
    this.printStackTrace(PrintWriter(trace))
    return trace.toString()
}

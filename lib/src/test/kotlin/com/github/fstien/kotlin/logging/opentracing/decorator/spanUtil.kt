package com.github.fstien.kotlin.logging.opentracing.decorator

import com.zopa.ktor.opentracing.getGlobalTracer
import io.opentracing.Span

inline fun <T> span(name: String = "defaultSpanName", block: Span.() -> T): T {
    val tracer = getGlobalTracer()
    val span = tracer.buildSpan(name).start()

    try {
        tracer.scopeManager().activate(span).use { scope ->
            return block(span)
        }
    } finally {
        span.finish()
    }
}
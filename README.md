 [![Download](https://api.bintray.com/packages/fstien/kotlin-logging-opentracing-decorator/kotlin-logging-opentracing-decorator/images/download.svg)](https://bintray.com/fstien/kotlin-logging-opentracing-decorator/kotlin-logging-opentracing-decorator/_latestVersion)
 ![GitHub](https://img.shields.io/github/license/fstien/kotlin-logging-opentracing-decorator.svg?color=green&style=popout)
[![Unit Tests Actions Status](https://github.com/zopaUK/ktor-opentracing/workflows/Unit%20Tests/badge.svg)](https://github.com/{userName}/{repoName}/actions)

# [kotlin-logging](https://github.com/MicroUtils/kotlin-logging) OpenTracing Decorator

Small library on top of [kotlin-logging](https://github.com/MicroUtils/kotlin-logging) which writes  [OpenTracing logs](https://opentracing.io/docs/overview/tags-logs-baggage/#logs) in addition to regular logs, by the means of a [decorator](https://en.wikipedia.org/wiki/Decorator_pattern). 


## Installation

Available for download from [jcenter](https://bintray.com/fstien/ktor-header-forwarding/ktor-header-forwarding).
### Maven
Add the following dependency to your `pom.xml`:
    
    <dependency>
      <groupId>com.github.fstien</groupId>
      <artifactId>kotlin-logging-opentracing-decorator</artifactId>
      <version>0.1.0</version>
      <type>pom</type>
    </dependency>

### Gradle
Add the following to your dependencies in your `build.gradle`:

    implementation 'com.github.fstien:kotlin-logging-opentracing-decorator:0.1.0'

## Getting Started 
In an application with a tracer registered in [GlobalTracer](https://opentracing.io/guides/java/tracers/#global-tracer), extend your regular [logger](https://github.com/MicroUtils/kotlin-logging) instance with OpenTracing logs: 
```kotlin
val logger = KotlinLogging.logger {}.withOpenTracingLogs()
```
You can now use the `logger` as before as it still implements the [KLogger](https://github.com/MicroUtils/kotlin-logging/blob/master/src/jvmMain/kotlin/mu/KLogger.kt) interfaces. Hence, if you are already using [kotlin-logging](https://github.com/MicroUtils/kotlin-logging), you do not need to make any further changes to your application. 

## Example
For use in a [Ktor](https://ktor.io/) application, see [kotlin-logging-opentracing-decorator-example](https://github.com/fstien/kotlin-logging-opentracing-decorator-example).

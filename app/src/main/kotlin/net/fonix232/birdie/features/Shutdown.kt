package net.fonix232.birdie.features

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.server.engine.ShutDownUrl

fun Application.shutdown() {
    install(ShutDownUrl.ApplicationCallFeature) {
        // The URL that will be intercepted (you can also use the application.conf's ktor.deployment.shutdown.url key)
        // shutDownUrl = "/shutdown"
        // A function that will be executed to get the exit code of the process
        exitCodeSupplier = { 0 } // ApplicationCall.() -> Int
    }
}
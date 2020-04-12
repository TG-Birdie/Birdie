package net.fonix232.birdie.features

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ConditionalHeaders

fun Application.conditionalHeaders() {
    install(ConditionalHeaders) {

    }
}
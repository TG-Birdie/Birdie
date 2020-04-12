package net.fonix232.birdie.features

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.Compression
import io.ktor.features.deflate
import io.ktor.features.gzip
import io.ktor.features.minimumSize

fun Application.compression() {
    install(Compression) {
        gzip {
            priority = 1.0
        }
        deflate {
            priority = 10.0
            minimumSize(1024) // condition
        }
    }
}
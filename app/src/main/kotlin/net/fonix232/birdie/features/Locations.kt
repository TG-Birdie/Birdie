package net.fonix232.birdie.features

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.locations.Locations

fun Application.locations() {
    install(Locations)
}
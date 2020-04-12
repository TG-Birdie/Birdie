package net.fonix232.birdie.features

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.sessions.Sessions
import io.ktor.sessions.cookie
import net.fonix232.birdie.models.Session

fun Application.sessions() {
    install(Sessions) {
        cookie<Session>("BIRDIE_SESSION") {

        }
    }
}
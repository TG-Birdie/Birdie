package net.fonix232.birdie.features

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.basic
import io.ktor.auth.session
import net.fonix232.birdie.models.Session

fun Application.authentication() {
    install(Authentication) {
        session<Session> {
            validate { it.userName?.let { name -> UserIdPrincipal(name) } } // TODO: Better session security
        }
        basic("myBasicAuth") {
            realm = "Ktor Server"
            validate { if (it.name == "test" && it.password == "password") UserIdPrincipal(it.name) else null }
        }
    }
}
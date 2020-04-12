package net.fonix232.birdie.routes

import io.ktor.application.call
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.authenticate
import io.ktor.auth.principal
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get

fun Routing.auth() {
    authenticate("myBasicAuth") {
        get("/protected/route/basic") {
            val principal = call.principal<UserIdPrincipal>()!!
            call.respondText("Hello ${principal.name}")
        }
    }
}
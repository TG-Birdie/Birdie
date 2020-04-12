package net.fonix232.birdie.routes

import io.ktor.application.call
import io.ktor.application.install
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.authenticate
import io.ktor.auth.principal
import io.ktor.features.StatusPages
import io.ktor.html.respondHtml
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import net.fonix232.birdie.AuthenticationException
import net.fonix232.birdie.AuthorizationException

fun Routing.main() {

}
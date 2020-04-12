package net.fonix232.birdie

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.auth.*
import io.ktor.features.*
import io.ktor.gson.gson
import io.ktor.http.*
import io.ktor.http.content.CachingOptions
import io.ktor.locations.Locations
import io.ktor.request.path
import io.ktor.routing.routing
import io.ktor.server.engine.ShutDownUrl
import io.ktor.sessions.Sessions
import io.ktor.sessions.cookie
import io.ktor.util.date.GMTDate
import net.fonix232.birdie.di.appModule
import net.fonix232.birdie.features.*
import net.fonix232.birdie.models.Session
import org.koin.ktor.ext.Koin
import org.slf4j.event.Level

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.main(testing: Boolean = false) {
    install(Koin.Feature) {
        modules(appModule)
    }

    authentication()
    cachingHeaders()
    callLogging()
    compression()
    conditionalHeaders()
    install(ContentNegotiation) {
        gson {}
    }
    cors()
    install(DataConversion)
    install(DefaultHeaders) {
        header("X-Application", "Birdie")
    }
    httpsRedirect(testing)
    locations()
    sessions()
    shutdown()

    routing(configuration = net.fonix232.birdie.routes)
}
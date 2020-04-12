/*
 * This file is part of Birdie (https://github.com/TG-Birdie/Birdie/)
 * Copyright (c) 2020 Jozsef Kiraly <fonix232@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package net.fonix232.birdie

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.DataConversion
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.routing.routing
import net.fonix232.birdie.di.appModule
import net.fonix232.birdie.features.*
import org.koin.ktor.ext.Koin

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

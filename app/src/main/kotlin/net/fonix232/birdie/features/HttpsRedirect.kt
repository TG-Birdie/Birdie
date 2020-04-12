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

package net.fonix232.birdie.features

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.HttpsRedirect

private const val SSL_PORT = 443

fun Application.httpsRedirect(testing: Boolean) {
    if (!testing) {
        install(HttpsRedirect) {
            // The port to redirect to. By default 443, the default HTTPS port.
            sslPort = SSL_PORT
            // 301 Moved Permanently, or 302 Found redirect.
            permanentRedirect = true
        }
    }
}

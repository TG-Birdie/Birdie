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

package net.fonix232.birdie.routes

import io.ktor.application.call
import io.ktor.routing.Routing
import io.ktor.routing.get
import net.fonix232.birdie.extensions.respondCss
import net.fonix232.birdie.styles.ThemeManager
import org.koin.ktor.ext.inject

fun Routing.styles() {

    val themeManager by inject<ThemeManager>()

    get("styles/main.css") {
        call.respondCss(themeManager.getCurrentTheme())
    }
}

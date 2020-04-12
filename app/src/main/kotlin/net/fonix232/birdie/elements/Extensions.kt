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

package net.fonix232.birdie.elements

import kotlinx.html.HEAD
import kotlinx.html.link
import kotlinx.html.script

fun HEAD.addBootstrap() {
    link {
        rel = "stylesheet"
        href = "https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity = "sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
    }
    script {
        src = "https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity = "sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
    }
    script {
        src = "https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity = "sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
    }
    script {
        src = "https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity = "sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
    }
}

fun HEAD.addIonIcons() {
    script { src = "https://unpkg.com/ionicons@5.0.0/dist/ionicons.js" }
}

fun HEAD.addGoogleFont(fontFamily: String) {
    link {
        href = "https://fonts.googleapis.com/css2?family=${fontFamily.googleFontize()}" +
            ":ital,wght@0,300;0,400;0,600;0,700;1,300;1,400;1,600;1,700&display=swap"
        rel = "stylesheet"
    }
}

private fun String.googleFontize() = replace(' ', '+')

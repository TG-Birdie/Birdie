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
import io.ktor.features.Compression
import io.ktor.features.deflate
import io.ktor.features.gzip
import io.ktor.features.minimumSize

private const val GZIP_PRIORITY = 1.0
private const val DEFLATE_PRIORITY = 10.0
private const val DEFLATE_MINIMUMSIZE = 1024L

fun Application.compression() {
    install(Compression) {
        gzip {
            priority = GZIP_PRIORITY
        }
        deflate {
            priority = DEFLATE_PRIORITY
            minimumSize(DEFLATE_MINIMUMSIZE) // condition
        }
    }
}

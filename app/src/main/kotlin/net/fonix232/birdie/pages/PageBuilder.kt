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

package net.fonix232.birdie.pages

import kotlinx.html.HTML
import kotlinx.html.body
import net.fonix232.birdie.elements.Footer
import net.fonix232.birdie.elements.Header

class PageBuilder(val title: String, val content: PageBase) {

    val header: Header
        get() = Header(title)

    val footer: Footer
        get() = Footer()

    fun builder(): HTML.() -> Unit = {
        header.builder
        body {
            content.builder
        }
        footer.builder
    }
}

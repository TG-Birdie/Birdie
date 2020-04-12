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

package plugins

import io.gitlab.arturbosch.detekt.DetektPlugin
import io.gitlab.arturbosch.detekt.extensions.DetektExtension

apply<DetektPlugin>()

configure<DetektExtension> {
    config = files("$rootDir/.detekt/config.yml")
    //filters = ".*build.*,.*/resources/.*,.*/tmp/.*"
    reports {
        xml {
            enabled = true
            destination = project.file("build/reports/detekt/report.xml")
        }
        html {
            enabled = true
            destination = project.file("build/reports/detekt/report.html")
        }
    }
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt> {
    exclude("**build**,**/resources/**,**/tmp/**")
}

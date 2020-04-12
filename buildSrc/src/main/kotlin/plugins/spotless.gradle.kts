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

import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin

apply<SpotlessPlugin>()

@Suppress("INACCESSIBLE_TYPE")
configure<SpotlessExtension> {
    format("misc") {
        target("**/*.md", "**/.gitignore", "**/*.yaml", "**/*.yml")
        targetExclude(".gradle/**", ".gradle-cache/**", "**/tools/**", "**/build/**")
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }

    format("xml") {
        target("**/res/**/*.xml")
        indentWithSpaces(4)
        trimTrailingWhitespace()
        endWithNewline()
    }

    kotlin {
        target("**/*.kt")
        targetExclude("**/build/**", "**/buildSrc/**", "**/.*", ".spotless/*")
        licenseHeaderFile(rootProject.file(".spotless/copyright.kt"))
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }

    kotlinGradle {
        target("**/*.gradle.kts", "*.gradle.kts")
        targetExclude("**/build/**")
        licenseHeaderFile(
            rootProject.file(".spotless/copyright.kt"),
            "package|import|tasks|apply|plugins|include|val|object|interface"
        )
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }
}

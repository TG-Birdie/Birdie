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

plugins {
    base
    kotlin("jvm") apply false
    BuildPlugins.GIT_HOOKS
    BuildPlugins.UPDATE_DEPENDENCIES
}

allprojects {

    group = if(path.contains("plugins")) Dependencies.Birdie.Plugins.GROUP else Dependencies.Birdie.GROUP
    version = Versions.Birdie

    plugins.apply(BuildPlugins.DETEKT)
    plugins.apply(BuildPlugins.DOKKA)
    plugins.apply(BuildPlugins.KTLINT)
    plugins.apply(BuildPlugins.SPOTLESS)

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    repositories {
        jcenter()
        maven("https://kotlin.bintray.com/kotlin-js-wrappers" )
        maven("https://kotlin.bintray.com/ktor")
        maven("https://jitpack.io")
    }
}

dependencies {
    // Make the root project archives configuration depend on every sub-project
    subprojects.forEach {
        archives(it)
    }
}

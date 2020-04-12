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
    application
    shadow
    kotlin("jvm")
    kotlin("kapt")
}

kotlinProject()

application {
    applicationName = "Birdie"
    mainClassName = "io.ktor.server.netty.EngineMain"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":common"))

    implementation(Dependencies.Ktor.Server.Netty)
    implementation(Dependencies.Ktor.Server.Core)
    implementation(Dependencies.Ktor.Server.Sessions)

    implementation(Dependencies.Ktor.HtmlBuilder)
    implementation(Dependencies.KotlinX.HTML)
    implementation(Dependencies.KotlinX.CSS)
    implementation(Dependencies.Ktor.GSON)

    implementation(Dependencies.Ktor.Server.HostCommon)
    implementation(Dependencies.Ktor.Locations)
    implementation(Dependencies.Ktor.Metrics)
    implementation(Dependencies.Ktor.WebSockets)

    implementation(Dependencies.Ktor.Auth.Basic)
    implementation(Dependencies.Ktor.Auth.JWT)

    compile("ch.qos.logback:logback-classic:1.2.3")

    implementation(Dependencies.TelegramBot.Core)

    implementation(Dependencies.PF4J.Core)
    implementation(Dependencies.PF4J.Update)

    implementation(Dependencies.Koin.Core)
    implementation(Dependencies.Koin.Ext)
    implementation(Dependencies.Koin.Ktor)
}

sourceSets.forEach {
    it.java.srcDir("src/${it.name}/java")
    it.resources.srcDir("src/${it.name}/resources")
}

kotlin.sourceSets.forEach {
    it.kotlin.srcDir("src/${it.name}/kotlin")
}

tasks.withType<Jar> {
    archiveBaseName.set(application.applicationName)
    manifest {
        attributes(
            mapOf(
                "Main-Class" to application.mainClassName
            )
        )
    }
}

tasks.withType<AbstractArchiveTask> {
    isPreserveFileTimestamps = true
    isReproducibleFileOrder = true
}

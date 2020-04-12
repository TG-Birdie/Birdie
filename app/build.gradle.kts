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

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions.jvmTarget = "1.8"
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
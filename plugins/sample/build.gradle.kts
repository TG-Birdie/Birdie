plugins {
    shadow
    kotlin("jvm")
    kotlin("kapt")
}

kotlinProject()

dependencies {
    implementation(project(Dependencies.Birdie.Common.project))
}

tasks.withType<Jar> {
    archiveBaseName.set("${project.group}.${archiveBaseName.get()}")
    archiveVersion.set("v${archiveVersion.get()}")
}
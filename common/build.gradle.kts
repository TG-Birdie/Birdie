plugins {
    shadow
    kotlin("jvm")
}

kotlinProject()

dependencies {
    api(Dependencies.KotlinX.HTML)
    api(Dependencies.KotlinX.CSS)

    api(Dependencies.PF4J.Core)
}
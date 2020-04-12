plugins {
    base
    kotlin("jvm") version Versions.Kotlin apply false
}

allprojects {

    group = if(path.contains("plugins")) Dependencies.Birdie.Plugins.GROUP else Dependencies.Birdie.GROUP
    version = Versions.Birdie

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
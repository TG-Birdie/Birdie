package net.fonix232.birdie.routes

import io.ktor.application.call
import io.ktor.routing.Routing
import io.ktor.routing.get
import net.fonix232.birdie.extensions.respondCss
import net.fonix232.birdie.styles.ThemeManager
import org.koin.ktor.ext.inject

fun Routing.styles() {

    val themeManager by inject<ThemeManager>()

    get("styles/main.css") {
        call.respondCss(themeManager.getCurrentTheme())
    }
}
package net.fonix232.birdie.elements

import kotlinx.html.*

class Header(val title: String) {
    val builder: HTML.() -> Unit
        get() = {
            head {
                meta { charset = "utf-8" }
                title(content = this@Header.title)
                addBootstrap()
                addIonIcons()
                addGoogleFont("Titillium Web")
            }
        }
}
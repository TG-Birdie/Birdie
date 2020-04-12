package net.fonix232.birdie.pages

import kotlinx.html.FlowContent
import kotlinx.html.HTML
import kotlinx.html.body
import kotlinx.html.visit
import net.fonix232.birdie.elements.ElementBase
import net.fonix232.birdie.elements.Footer
import net.fonix232.birdie.elements.Header

class PageBuilder(val title: String, val content: PageBase) {

    val header: Header
        get() = Header(title)

    val footer: Footer
        get() = Footer()

    val builder: HTML.() -> Unit
        get() = {
            header.builder
            body {
                content.builder
            }
            footer.builder
        }
}
package net.fonix232.birdie.pages

import kotlinx.html.FlowContent

interface PageBase {
    val builder: FlowContent.() -> Unit
}
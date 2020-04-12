package net.fonix232.birdie.elements

import kotlinx.html.FlowContent

interface ElementBase {
    val builder: FlowContent.() -> Unit
}
package net.fonix232.birdie.plugin

import kotlinx.html.FlowContent
import kotlinx.html.HTML

interface WebInterface {
    val webInterface: FlowContent.() -> Unit
    val menuName: String
}
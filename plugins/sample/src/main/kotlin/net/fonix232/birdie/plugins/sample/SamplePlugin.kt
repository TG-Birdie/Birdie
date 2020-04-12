package net.fonix232.birdie.plugins.sample

import kotlinx.html.*
import net.fonix232.birdie.models.Message
import net.fonix232.birdie.plugin.BirdiePlugin
import net.fonix232.birdie.plugin.MessageHandler
import net.fonix232.birdie.plugin.WebInterface
import org.pf4j.Extension
import org.pf4j.PluginWrapper

class SamplePlugin(wrapper: PluginWrapper): BirdiePlugin(wrapper) {

    @Extension
    object SampleMessageHandler: MessageHandler {
        override fun onMessage(message: Message) {
            // TODO: Do something with the message here!
        }
    }

    @Extension
    object SampleWebInterface: WebInterface {
        override val menuName: String = "Sample Plugin"

        override val webInterface: FlowContent.() -> Unit
            get() = {
                div {
                    h1 { +"Do some text magic here" }
                }
            }
    }

}
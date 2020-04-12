/*
 * This file is part of Birdie (https://github.com/TG-Birdie/Birdie/)
 * Copyright (c) 2020 Jozsef Kiraly <fonix232@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

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

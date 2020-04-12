package net.fonix232.birdie.plugin

import net.fonix232.birdie.models.Message

interface MessageHandler {
    fun onMessage(message: Message)
}
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

package net.fonix232.birdie.services

import me.ivmg.telegram.Bot
import me.ivmg.telegram.bot
import me.ivmg.telegram.dispatch
import me.ivmg.telegram.dispatcher.text
import net.fonix232.birdie.providers.EnvironmentProvider
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.KoinComponent
import org.koin.core.inject

class BotServiceImpl(private val telegramBotKey: String? = null) : BotService, KoinComponent {

    companion object {
        private const val TIMEOUT = 30

        // TODO: Move this into a Koin factory
        private fun buildBot(botKey: String): Bot = bot {
            token = botKey
            timeout = TIMEOUT
            logLevel = HttpLoggingInterceptor.Level.BODY
            dispatch {
                text { bot, update ->
                    // TODO: Send out notification to bots
                }
                text("ping") { bot, update ->
                    bot.sendMessage(update.message!!.chat.id, "Pong")
                }
            }
        }
    }

    private val envProvider: EnvironmentProvider by inject()

    private lateinit var bot: Bot

    init {
        init()
    }

    override fun start() {
        bot.startPolling()
    }

    override fun stop() {
        bot.stopPolling()
    }

    override fun reload() {
        bot.stopPolling()
        init()
    }

    private fun init() {
        bot = buildBot(telegramBotKey ?: envProvider.telegramBotKey ?: throw IllegalArgumentException())
        bot.startPolling()
    }
}

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

package net.fonix232.birdie.plugin

import org.pf4j.PluginManager

class PluginManager(private val manager: PluginManager) {

    init {
        //manager.startedPlugins.all { it. }
    }

    fun load() {
        manager.loadPlugins()
    }

    fun enable(pluginId: String) {
        manager.enablePlugin(pluginId)
    }

    fun disable(pluginId: String) {
        manager.disablePlugin(pluginId)
    }


    fun getWebInterfaces(): List<WebInterface> = manager.getExtensions()
    fun getMessageHandlers(): List<MessageHandler> = manager.getExtensions()
    fun getDependencyProviders(): List<DependencyProvider> = manager.getExtensions()
    fun getPluginConfigurations(): List<PluginConfiguration> = manager.getExtensions()
}

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

inline fun <reified T> PluginManager.getExtensions(): List<T> = getExtensions(T::class.java)
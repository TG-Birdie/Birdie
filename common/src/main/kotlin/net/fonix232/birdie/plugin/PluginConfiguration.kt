package net.fonix232.birdie.plugin

interface PluginConfiguration {
    fun saveConfiguration(): String
    fun loadConfiguration(configuration: String)
    fun setOnConfigurationChangedListener(listener: PluginConfigurationChangeListener)
    fun removeOnConfigurationChangedListener()

    interface PluginConfigurationChangeListener {
        fun onPluginConfigurationChanged(configuration: String)
    }
}


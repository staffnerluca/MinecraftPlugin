package org.test.improvedweapons

import org.bukkit.plugin.java.JavaPlugin
import org.test.improvedcombatsystem.SwordImproved

class ImprovedWeapons : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        server.pluginManager.registerEvents(Test(), this)
        server.pluginManager.registerEvents(BowImproved(), this)
        server.pluginManager.registerEvents(SwordImproved(), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}

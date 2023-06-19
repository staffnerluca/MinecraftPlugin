package org.test.improvedcombatsystem;

import org.bukkit.plugin.java.JavaPlugin;

public final class ImprovedCombatSystem extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        getServer().getPluginManager().registerEvents(new test(), this);
        getServer().getPluginManager().registerEvents(new TeleportArr(), this);
        getServer().getPluginManager().registerEvents(new sword(), this);

    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

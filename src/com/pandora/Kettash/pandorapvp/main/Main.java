package com.pandora.Kettash.pandorapvp.main;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    private static Main instance;

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;

        //getServer().getPluginManager().registerEvents(new com.pandora.Kettash.pandorapvp.main.Soup(), this); Disabled for the UHC
        getServer().getPluginManager().registerEvents(new OldPvp(), this);

    }

    public Main getInstance() {
        return instance;
    }
}

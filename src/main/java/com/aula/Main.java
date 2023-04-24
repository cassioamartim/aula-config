package com.aula;

import com.aula.config.ConfigAPI;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        new ConfigAPI("status", getDataFolder());
    }
}
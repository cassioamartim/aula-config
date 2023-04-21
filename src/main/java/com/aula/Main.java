package com.aula;

import com.aula.config.ConfigAPI;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        ConfigAPI configAPI = new ConfigAPI("status", getDataFolder());

        System.out.println(configAPI.getInt("cassio.kills"));
        System.out.println(configAPI.getString("cassio.livro"));

    }
}
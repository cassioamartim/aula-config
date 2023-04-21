package com.aula.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigAPI {

    private final String configName;

    private final FileConfiguration config;

    private final File directory;

    private final File yamlConfig;

    public ConfigAPI(String configName, File directory) {
        StringBuilder builder = new StringBuilder();

        builder.append(configName).append(".yml");

        this.configName = builder.toString();

        System.out.println(directory);

        this.directory = directory;

        this.yamlConfig = new File(directory + "/" + this.configName);

        if (!directory.exists()) {
            directory.mkdir();
        }

        if (!yamlConfig.exists()) {
            try {
                yamlConfig.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        this.config = YamlConfiguration.loadConfiguration(yamlConfig);

        this.config.addDefault("cassio.kills", 10);
        this.config.addDefault("cassio.livro", "Bartolomeu");

        this.config.options().copyDefaults(true);

        save();
    }

    public String getString(String path) {
        return config.getString(path);
    }

    public int getInt(String path) {
        return config.getInt(path);
    }

    public void save() {
        try {
            this.config.save(yamlConfig);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

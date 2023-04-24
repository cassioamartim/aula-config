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
        this.configName = configName + ".yml";

        this.directory = directory;

        this.yamlConfig = new File(directory + "/" + this.configName);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        if (!yamlConfig.exists()) {
            try {
                yamlConfig.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        this.config = YamlConfiguration.loadConfiguration(yamlConfig);

        File newDirectory = new File(directory, "jogadores");

        if (!newDirectory.exists()) {
            newDirectory.mkdirs();
        }

        File jogadores = new File(newDirectory, "jogadores.yml");

        if (!jogadores.exists()) {
            try {
                jogadores.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        FileConfiguration jogadorConfig = YamlConfiguration.loadConfiguration(jogadores);

        jogadorConfig.set("jogador.Cassio.nome", "Cassio");
        jogadorConfig.set("jogador.Cassio.idade", 17);

        try {
            jogadorConfig.save(jogadores);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Sucesso!");
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

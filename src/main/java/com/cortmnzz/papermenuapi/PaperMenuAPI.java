package com.cortmnzz.papermenuapi;

import com.cortmnzz.papermenuapi.listener.InventoryClickListener;
import com.cortmnzz.papermenuapi.listener.PlayerJoinListener;
import com.cortmnzz.papermenuapi.player.PaperPlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PaperMenuAPI extends JavaPlugin {

    PaperPlayerManager paperPlayerManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        paperPlayerManager = new PaperPlayerManager(this);

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public PaperPlayerManager getPaperPlayerManager() {
        return paperPlayerManager;
    }
}

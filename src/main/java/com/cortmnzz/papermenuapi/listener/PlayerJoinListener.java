package com.cortmnzz.papermenuapi.listener;

import com.cortmnzz.papermenuapi.PaperMenuAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    private final PaperMenuAPI plugin;

    public PlayerJoinListener(PaperMenuAPI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        plugin.getPaperPlayerManager().addPaperPlayer(event.getPlayer());
    }
}

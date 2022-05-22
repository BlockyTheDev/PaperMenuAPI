package com.cortmnzz.papermenuapi.player;

import com.cortmnzz.papermenuapi.PaperMenuAPI;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class PaperPlayerManager {
    PaperMenuAPI plugin;
    Map<Player, PaperPlayer> playerMap;

    public PaperPlayerManager(PaperMenuAPI plugin) {
        this.plugin = plugin;
        playerMap = new HashMap<>();
    }
    public void addPaperPlayer(Player player) {
        if (playerMap.get(player) == null) {
            playerMap.put(player, new PaperPlayer(plugin, player));
        }
    }
    public PaperPlayer getPaperPlayer(Player player) {
        return playerMap.get(player);
    }
}

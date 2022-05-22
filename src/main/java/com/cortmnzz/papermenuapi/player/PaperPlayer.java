package com.cortmnzz.papermenuapi.player;

import com.cortmnzz.papermenuapi.PaperMenuAPI;
import com.cortmnzz.papermenuapi.menu.PaperMenu;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

public class PaperPlayer {
    PaperMenuAPI plugin;
    @Getter @Setter
    Player bukkitPlayer;
    @Getter @Setter
    PaperMenu lastOpenedMenu;

    public PaperPlayer(PaperMenuAPI plugin, Player bukkitPlayer) {
        this.plugin = plugin;
        this.bukkitPlayer = bukkitPlayer;
    }
}

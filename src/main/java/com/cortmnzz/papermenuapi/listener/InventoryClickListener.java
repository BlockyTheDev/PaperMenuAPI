package com.cortmnzz.papermenuapi.listener;

import com.cortmnzz.papermenuapi.PaperMenuAPI;
import com.cortmnzz.papermenuapi.menu.PaperMenu;
import com.cortmnzz.papermenuapi.player.PaperPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
    private final PaperMenuAPI plugin;

    public InventoryClickListener(PaperMenuAPI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            PaperPlayer paperPlayer = plugin.getPaperPlayerManager().getPaperPlayer((Player) event.getWhoClicked());

            if (event.getClickedInventory() == null) {
                return;
            }
            PaperMenu paperMenu = paperPlayer.getLastOpenedMenu();
            if (paperMenu != null) {
                event.setCancelled(true);
                Runnable runnable = paperMenu.getRunnable(event.getSlot());
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }
}

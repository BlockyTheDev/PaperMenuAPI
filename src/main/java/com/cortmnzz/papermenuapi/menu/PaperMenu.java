package com.cortmnzz.papermenuapi.menu;

import com.cortmnzz.papermenuapi.PaperMenuAPI;
import com.cortmnzz.papermenuapi.player.PaperPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class PaperMenu {
    PaperMenuAPI plugin;
    PaperPlayer paperPlayer;
    String title;
    Inventory bukkitInventory;
    Map<Integer, Runnable> actionMap;
    int taskID;

    public PaperMenu(PaperMenuAPI plugin, PaperPlayer paperPlayer, String title) {
        this.plugin = plugin;
        this.paperPlayer = paperPlayer;
        this.title = title;
        actionMap = new HashMap<>();
    }
    public PaperMenu setType(InventoryType inventoryType) {
        this.bukkitInventory = Bukkit.createInventory(null, inventoryType, title);
        return this;
    }
    public PaperMenu setSize(int size) {
        this.bukkitInventory = Bukkit.createInventory(null, size, title);
        return this;
    }
    public void addItem(Integer slot, ItemStack itemStack) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> itemLore = itemMeta.getLore();


        bukkitInventory.setItem(slot, itemStack);
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

            @Override
            public void run() {
                if (bukkitInventory.getViewers().size() > 0) {

                    if (itemStack.getType() != Material.SKULL_ITEM) {
                        if (itemLore != null) {
                            itemMeta.setLore(itemLore);
                            itemStack.setItemMeta(itemMeta);
                        }

                        bukkitInventory.setItem(slot, itemStack);
                        paperPlayer.getBukkitPlayer().updateInventory();
                    }
                } else {
                    Bukkit.getScheduler().cancelTask(taskID);
                }
            }
        }, 0, 10L);
    }
    public PaperMenu addClickableItem(Integer slot, ItemStack itemStack, Runnable runnable) {
        actionMap.put(slot, runnable);
        addItem(slot, itemStack);
        return this;
    }
    public PaperMenu addClickableItem(List<Integer> slots, ItemStack itemStack, Runnable runnable) {
        slots.forEach(slot -> addClickableItem(slot, itemStack, runnable));
        return this;
    }
    public PaperMenu addItem(List<Integer> slots, ItemStack itemStack) {
        slots.forEach(slot -> addItem(slot, itemStack));
        return this;
    }
    public boolean openMenu() {
        paperPlayer.getBukkitPlayer().closeInventory();
        paperPlayer.getBukkitPlayer().openInventory(bukkitInventory);
        paperPlayer.setLastOpenedMenu(this);
        return true;
    }
    public Inventory getBukkitInventory() {
        return bukkitInventory;
    }
    public Runnable getRunnable(Integer slot) {
        return actionMap.get(slot);
    }
}

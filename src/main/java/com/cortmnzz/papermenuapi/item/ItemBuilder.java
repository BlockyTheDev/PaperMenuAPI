package com.cortmnzz.papermenuapi.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

@SuppressWarnings("unused")
public class ItemBuilder {
    ItemStack itemStack;
    ItemMeta itemMeta;

    public ItemBuilder(Material material) {
        itemStack = new ItemStack(material);
        itemMeta = itemStack.getItemMeta();
    }
    public ItemBuilder setDisplayName(String displayName) {
        itemMeta.setDisplayName(displayName);
        return this;
    }
    public ItemBuilder setLore(List<String> lore) {
        itemMeta.setLore(lore);
        return this;
    }
    public ItemBuilder setData(int data) {
        itemStack.setDurability((short) data);
        return this;
    }
    public ItemBuilder hideAttributes() {
        itemStack.getItemMeta().getItemFlags().add(ItemFlag.HIDE_ATTRIBUTES);
        return this;
    }
    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public ItemBuilder setBookAuthor(String value) {
        BookMeta bookMeta = (BookMeta) itemMeta;
        bookMeta.setAuthor(value);
        itemMeta = bookMeta;
        return this;
    }
    public ItemBuilder setBookPages(List<String> pages) {
        BookMeta bookMeta = (BookMeta) itemMeta;
        bookMeta.setPages(pages);
        itemMeta = bookMeta;
        return this;
    }
    public ItemBuilder addEnchantment(Enchantment enchantment, int level) {
        itemStack.addEnchantment(enchantment, 1);
        return this;
    }
    public ItemBuilder removeEnchantment(Enchantment enchantment) {
        itemStack.removeEnchantment(enchantment);
        return this;
    }
}

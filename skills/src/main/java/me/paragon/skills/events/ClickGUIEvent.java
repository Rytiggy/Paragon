package me.paragon.skills.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ClickGUIEvent implements Listener {

    @EventHandler
    public void clickGUIEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if(e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.BLUE +"Skills")){

            switch(e.getCurrentItem().getType()) {
                case ELYTRA:
                    player.sendMessage(ChatColor.AQUA + "[Skills] Equipped Glider");
                    player.closeInventory();

                    ItemStack glider  = new ItemStack(Material.ELYTRA);
                    ItemMeta gliderMeta = glider.getItemMeta();
                    gliderMeta.setDisplayName(ChatColor.BLUE + "Glider");
                    ArrayList<String> gliderLore = new ArrayList<>();
                    gliderLore.add(ChatColor.AQUA + "Equips a Glider.");
                    gliderLore.add(ChatColor.GRAY + "Level 1 out of 10");
                    gliderLore.add(ChatColor.GRAY + "Current level: 15 second cool down");
                    gliderLore.add(ChatColor.GRAY + "Next level: 14 second cool down");
                    gliderMeta.setLore(gliderLore);
                    glider.setItemMeta(gliderMeta);

                    ItemStack boostSpell  = new ItemStack(Material.FEATHER);
                    ItemMeta boostSpellMeta = boostSpell.getItemMeta();
                    boostSpellMeta.setDisplayName(ChatColor.BLUE + "Boost");
                    ArrayList<String> boostSpellLore = new ArrayList<>();
                    boostSpellLore.add(ChatColor.AQUA + "Boost player forward");
                    boostSpellLore.add(ChatColor.GRAY + "Level 1 out of 10");
                    boostSpellLore.add(ChatColor.GRAY + "Current level: 15 second cool down");
                    boostSpellLore.add(ChatColor.GRAY + "Next level: 14 second cool down");
                    boostSpellMeta.setLore(boostSpellLore);
                    boostSpell.setItemMeta(boostSpellMeta);


                    player.getInventory().setChestplate(glider);
                    player.getInventory().setItem(8, boostSpell);

            }

            e.setCancelled(true);
        }
    }
}

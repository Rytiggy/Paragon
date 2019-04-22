package me.paragon.skills.events;


import me.paragon.skills.Skills;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;

public class SwitchInventory implements Listener {
    ArrayList cooldown = new ArrayList<Player>();

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        final Player player = e.getPlayer();

        //if it was a right click
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK ||  e.getAction() == Action.RIGHT_CLICK_AIR) {
            if(e.getPlayer().getInventory().getItemInMainHand().getType() == Material.FEATHER) {
                //check if player are in a cool down
                if(cooldown.contains(player)) {
                    player.sendMessage(ChatColor.RED + "Please wait: this skill is not ready yet");
                } else {
                    // TODO: Make sure player is flying
                    // TODO: check players speed
                    Vector v = player.getVelocity();
                    v = v.multiply(3);
                    player.setVelocity(v);
                    cooldown.add(player);

                    ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
                    player.getInventory().setItem(8, item);

                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("skills"), new Runnable() {
                        @Override
                        public void run() {
                            cooldown.remove(player);
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

                            player.getInventory().setItem(8, boostSpell);

                        }
                    }, 300); // 0.05 * 300 = 15 sec
                }
                e.setCancelled(true);
            }

            }
    }
}

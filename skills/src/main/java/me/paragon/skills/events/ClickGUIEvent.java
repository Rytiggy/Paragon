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
                    gliderLore.add(ChatColor.GRAY + "Next level: 10 second cool down");
                    gliderMeta.setLore(gliderLore);

                    glider.setItemMeta(gliderMeta);


                    player.getInventory().setChestplate(glider);
            }

            e.setCancelled(true);
        }
    }
}

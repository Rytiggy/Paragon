package me.paragon.skills.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class OpenMenu implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            Inventory gui = Bukkit.createInventory(player, 9 , ChatColor.BLUE +"Skills");

            ItemStack glider  = new ItemStack(Material.ELYTRA);
            ItemStack suicide = new ItemStack(Material.BONE);

            ItemMeta gliderMeta = glider.getItemMeta();
            gliderMeta.setDisplayName(ChatColor.BLUE + "Glider");

            ArrayList<String> gliderLore = new ArrayList<>();
            gliderLore.add(ChatColor.AQUA + "Equips a Glider.");
            gliderLore.add(ChatColor.GRAY + "Level 1 out of 10");
            gliderLore.add(ChatColor.GRAY + "Next level: 10 second cool down");
            gliderMeta.setLore(gliderLore);

            glider.setItemMeta(gliderMeta);


            ItemStack[] menuItems = {glider, suicide};
            gui.setContents((menuItems));

            player.openInventory(gui);
        }
        return true;
    }
}

package me.paragon.skills.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ToggleSkillBar implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            Inventory inventory = player.getInventory();
            player.sendMessage("Toogle Skill bar");
            if (inventory.getTitle().equals("Menu")) {
                player.sendMessage("" + inventory.getTitle());
                inventory.getStorageContents();
            }

            }
        return true;
    }

}
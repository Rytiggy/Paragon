package me.paragon.skills.events;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class SwitchInventory implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        //if it was a right click
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK ||  e.getAction() == Action.RIGHT_CLICK_AIR) {
            if(e.getPlayer().getInventory().getItemInMainHand().getType() == Material.WOODEN_HOE) {
                player.sendMessage(ChatColor.AQUA + "Right clicked stick");
                launchFirework(player, 3);
            }
        }
    }
    public void launchFirework(Player p, int speed) {
        Firework fw = (Firework) p.getWorld().spawn(p.getEyeLocation(), Firework.class);
        FireworkMeta meta = fw.getFireworkMeta();
        //use meta to customize the firework or add parameters to the method
        fw.setVelocity(p.getLocation().getDirection().multiply(speed));
        //speed is how fast the firework flies
    }
}

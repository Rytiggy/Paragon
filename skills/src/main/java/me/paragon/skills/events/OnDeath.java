package me.paragon.skills.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnDeath implements Listener {

    /*Player leaves bed event*/
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        event.getEntity().sendMessage(ChatColor.BLUE + "[Skills] Yikes, better luck next time!");
    }
}

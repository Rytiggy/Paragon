package me.paragon.skills;

        import me.paragon.skills.commands.OpenMenu;
        import me.paragon.skills.events.ClickGUIEvent;
        import me.paragon.skills.events.OnDeath;
        import me.paragon.skills.events.SwitchInventory;
        import org.bukkit.plugin.java.JavaPlugin;

public final class Skills extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Skills plugin is starting up");
        getServer().getPluginManager().registerEvents(new OnDeath(), this);
        getCommand("openmenu").setExecutor(new OpenMenu());
        getServer().getPluginManager().registerEvents(new ClickGUIEvent(), this);
        getServer().getPluginManager().registerEvents(new SwitchInventory(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Skills disabled");
    }
}



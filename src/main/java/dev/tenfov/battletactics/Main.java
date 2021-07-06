package dev.tenfov.battletactics;


import dev.tenfov.battletactics.events.JoinEvent;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import dev.tenfov.battletactics.events.Spawn;
import dev.tenfov.battletactics.events.TabCompleteSpawn;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("mobspawn").setExecutor(new Spawn());
        this.getCommand("mobspawn").setTabCompleter(new TabCompleteSpawn());
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);

    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

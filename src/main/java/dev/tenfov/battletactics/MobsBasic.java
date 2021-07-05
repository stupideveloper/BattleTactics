package dev.tenfov.battletactics;


import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import dev.tenfov.battletactics.events.Spawn;
import dev.tenfov.battletactics.events.TabCompleteSpawn;

public final class MobsBasic extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("mobspawn").setExecutor(new Spawn());
        this.getCommand("mobspawn").setTabCompleter(new TabCompleteSpawn());
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

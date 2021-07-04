package dev.tenfov.battletactics;


import dev.tenfov.battletactics.events.Spawn;
import dev.tenfov.battletactics.events.TabCompleteSpawn;
import org.bukkit.plugin.java.JavaPlugin;

public final class MobsBasic extends JavaPlugin {

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

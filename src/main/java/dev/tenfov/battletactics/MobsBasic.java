package dev.tenfov.battletactics;


import dev.tenfov.battletactics.events.Spawn;
import org.bukkit.plugin.java.JavaPlugin;

public final class MobsBasic extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("summonthegabe").setExecutor(new Spawn());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

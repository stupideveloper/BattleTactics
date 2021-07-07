package dev.tenfov.battletactics;


import dev.tenfov.battletactics.events.JoinEvent;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.map.MapView;
import org.bukkit.map.MapView.Scale;
import org.bukkit.plugin.java.JavaPlugin;

import dev.tenfov.battletactics.events.Spawn;
import dev.tenfov.battletactics.events.TabCompleteSpawn;
import dev.tenfov.battletactics.map.CustomMapRenderer;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("mobspawn").setExecutor(new Spawn());
        this.getCommand("mobspawn").setTabCompleter(new TabCompleteSpawn());
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        this.getServer().getPluginManager().registerEvents(this, this);

    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @EventHandler
    public void onMapInitialize(MapInitializeEvent e) {
        MapView mapView = e.getMap();
        mapView.setScale(Scale.FARTHEST);
        mapView.setUnlimitedTracking(false);
        mapView.getRenderers().clear();
        mapView.addRenderer(new CustomMapRenderer());
    }
}

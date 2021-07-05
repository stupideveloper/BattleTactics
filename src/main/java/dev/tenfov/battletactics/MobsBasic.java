package dev.tenfov.battletactics;


import dev.tenfov.battletactics.events.Spawn;
import dev.tenfov.battletactics.events.TabCompleteSpawn;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MobsBasic extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("mobspawn").setExecutor(new Spawn());
        this.getCommand("mobspawn").setTabCompleter(new TabCompleteSpawn());
        Bukkit.getPluginManager().registerEvents(this, this);
    }
    @EventHandler
    public void onMobDamage(EntityDamageEvent e) {
        if (e.getEntity().getPassengers().size()!=0) {
            List<Entity> passe = e.getEntity().getPassengers();
            if (passe.get(passe.size()-1).getType()==EntityType.ARMOR_STAND) {
                Entity ent = passe.get(passe.size()-1);
                LivingEntity enz = (LivingEntity) e.getEntity();
                Double hea = (enz.getHealth() + enz.getAbsorptionAmount());
                ent.setCustomName(hea.shortValue() + " ❤");
                ent.setCustomNameVisible(true);
            }
        }
    }

    @EventHandler
    public void onMobDeath(EntityDeathEvent e) {
        if (e.getEntity().getPassengers().size()!=0) {
            List<Entity> passe = e.getEntity().getPassengers();
            if (passe.get(passe.size()-1).getType()==EntityType.ARMOR_STAND) {
                Entity ent = passe.get(passe.size()-1);
                ent.remove();
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

package dev.tenfov.battletactics;


import dev.tenfov.battletactics.events.Spawn;
import dev.tenfov.battletactics.events.TabCompleteSpawn;

import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MobsBasic extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("mobspawn").setExecutor(new Spawn());
        this.getCommand("mobspawn").setTabCompleter(new TabCompleteSpawn());
    }
    @EventHandler
    public void onMobDamage(EntityDamageEvent e) {
        if (e.getEntity().getPassengers().size()!=0) {
            List<Entity> passe = e.getEntity().getPassengers();
            if (passe.get(passe.size()).getType()==EntityType.ARMOR_STAND) {
                Entity ent = passe.get(passe.size());
                LivingEntity enz = (LivingEntity) e.getEntity();
                Double hea = (enz.getHealth() + enz.getAbsorptionAmount());
                ent.setCustomName(hea + " ❤️️");
            }
        }
    }

    @EventHandler
    public void onMobDeath(EntityDeathEvent e) {
        if (e.getEntity().getPassengers().size()!=0) {
            List<Entity> passe = e.getEntity().getPassengers();
            if (passe.get(passe.size()).getType()==EntityType.ARMOR_STAND) {
                Entity ent = passe.get(passe.size());
                ent.remove();
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

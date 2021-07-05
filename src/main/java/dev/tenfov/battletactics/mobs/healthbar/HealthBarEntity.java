package dev.tenfov.battletactics.mobs.healthbar;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;

import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;

public class HealthBarEntity extends AreaEffectCloud {

    public HealthBarEntity(Location loc) {
        super(EntityType.AREA_EFFECT_CLOUD, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());
        this.setInvulnerable(true);
        this.setDuration(2147483647);
    }
    
}

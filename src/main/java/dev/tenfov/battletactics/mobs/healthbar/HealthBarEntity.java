package dev.tenfov.battletactics.mobs.healthbar;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.ArmorStand;

public class HealthBarEntity extends ArmorStand {

    public HealthBarEntity(Location loc) {
        super(EntityType.ARMOR_STAND, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());
        this.setInvulnerable(true);
        this.setInvisible(true);
    }
    
}

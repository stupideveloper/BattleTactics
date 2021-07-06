package dev.tenfov.battletactics.mobs.healthbar;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;

public class HealthBarEntity extends ArmorStand {

    private Entity parent;

    private int errors;

    private LivingEntity parentEntity;

    public HealthBarEntity(Location loc, Entity parent) {
        super(EntityType.ARMOR_STAND, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());

        // Makes the ArmorStand unkillable
        this.setInvulnerable(true);

        // Makes the ArmorStand invisible
        this.setInvisible(true);

        //Mkes the ArmorStand small
        this.setSmall(true);

        // Sets the parent entity
        this.parent = parent;
        if (parent instanceof LivingEntity) {
            
            // Makes getting the health of the parent much easier
            this.parentEntity = (LivingEntity) parent;
        } else {
            // If the parent isnt a LivingEntity, remove the ArmorStand
            this.remove(RemovalReason.DISCARDED);
        }
    }
    @Override 
    public void tick() {
        try {

            // Sets the location to that of the parent entity
            this.setPos(parent.getX(), parent.getY() + 1.25 + parentEntity.getEyeHeight() - 2, parent.getZ());
            
            // Calculates the health of the parent entity
            Float hea = (this.parentEntity.getHealth() + this.parentEntity.getAbsorptionAmount());

            // Gives the ArmorStand a name
            this.setCustomName(new TextComponent(hea.shortValue() + " ❤"));
            this.setCustomNameVisible(true);
            this.errors = 0;

            // Temporary Fix
            if (!parentEntity.isAlive()) {
                this.remove(RemovalReason.KILLED);
            }
        } catch (NullPointerException e) {

            // Remove if the parent entity never spawns
            this.errors = this.errors + 1;
            if (this.errors > 40) {
                this.remove(RemovalReason.KILLED);
            }
        }
    }
    
}

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

    private LivingEntity parentEntity;

    public HealthBarEntity(Location loc, Entity parent) {
        super(EntityType.ARMOR_STAND, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());
        this.setInvulnerable(true);
        this.setInvisible(true);
        this.parent = parent;
    }
    @Override 
    public void tick() {
        try {
        this.setPos(parent.getX(), parent.getY() + 0.025, parent.getZ());
        Float hea = (parentEntity.getHealth() + parentEntity.getAbsorptionAmount());
        this.setCustomName(new TextComponent(hea.shortValue() + " ❤"));
        this.setCustomNameVisible(true);
        if (!this.parent.isAlive()) {
            this.remove(RemovalReason.KILLED);
        }
        } catch (NullPointerException e) {
            
        }
    }
    
}

package dev.tenfov.battletactics.mobs.skeleton;


import net.minecraft.world.entity.ai.goal.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Skeleton;



public class SkeleMaster extends Skeleton {
    public SkeleMaster(Location loc) {
        super(EntityType.SKELETON,((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());

        this.setCustomName(new TextComponent(ChatColor.BOLD + "" + ChatColor.DARK_AQUA + "Skeleton Master"));
        this.setCustomNameVisible(true);

        this.goalSelector.removeAllGoals();
        this.goalSelector.addGoal(0, new RangedBowAttackGoal<Skeleton>(this, 1.0, 1, 1));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.4D, true));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.4D));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));

        this.setAbsorptionAmount(1024);
    }
}

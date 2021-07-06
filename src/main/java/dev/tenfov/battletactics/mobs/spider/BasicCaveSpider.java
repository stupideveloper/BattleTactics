package dev.tenfov.battletactics.mobs.spider;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Spider;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;


public class BasicCaveSpider extends CaveSpider {
    public BasicCaveSpider(Location loc) {
        super(EntityType.CAVE_SPIDER,((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());

        this.setCustomName(new TextComponent(ChatColor.BOLD + "" + ChatColor.RED + "| lvl 11 |" + ChatColor.YELLOW + " Cave Spider"));
        this.setCustomNameVisible(true);
        this.setDropChance(EquipmentSlot.HEAD, 0);

        // Add potion effects
        MobEffect effect1 = MobEffect.byId(25);
        MobEffectInstance effect = new MobEffectInstance(effect1, 10, 1, true,true,false);
        this.addEffect(effect);

        this.goalSelector.removeAllGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.7D, true));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.6D));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));

        this.setHealth(12);
        this.setAbsorptionAmount(12);
    }
}

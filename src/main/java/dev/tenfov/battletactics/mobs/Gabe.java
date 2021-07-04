package dev.tenfov.battletactics.mobs;


import java.util.Arrays;

import net.minecraft.world.entity.ai.goal.*;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;


public class Gabe extends Zombie {
    public Gabe(Location loc) {
        super(EntityType.ZOMBIE,((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());

        this.setCustomName(new TextComponent(ChatColor.BOLD + "" + ChatColor.YELLOW + "Gabriel"));
        this.setCustomNameVisible(true);

        ItemStack armorHead = new ItemStack(Material.LEATHER_HELMET,1);
        LeatherArmorMeta armorHeadMeta = (LeatherArmorMeta) armorHead.getItemMeta();
        armorHeadMeta.setUnbreakable(true);
        armorHeadMeta.setColor(Color.fromRGB(0,51,141));
        armorHead.setItemMeta(armorHeadMeta);
        this.setItemSlot(EquipmentSlot.HEAD,CraftItemStack.asNMSCopy(armorHead));

        this.setDropChance(EquipmentSlot.HEAD, 0);

        this.goalSelector.removeAllGoals();

        //this.goalSelector.addGoal(0, new MeleeAttackGoal(this,1.0,true));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.8D, true));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.6D));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));


        this.setAbsorptionAmount(8);
    }
}

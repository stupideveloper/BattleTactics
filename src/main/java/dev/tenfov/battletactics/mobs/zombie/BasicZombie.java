package dev.tenfov.battletactics.mobs.zombie;


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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Zombie;



public class BasicZombie extends Zombie {
    public BasicZombie(Location loc) {
        super(EntityType.ZOMBIE,((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());

        this.setCustomName(new TextComponent(ChatColor.BOLD + "" + ChatColor.RED + "|lvl 5|" + ChatColor.GREEN + " Zombie "));
        this.setCustomNameVisible(true);

        // Equip Items
        ItemStack armorHead = new ItemStack(Material.LEATHER_HELMET,1);
        LeatherArmorMeta armorHeadMeta = (LeatherArmorMeta) armorHead.getItemMeta();
        armorHeadMeta.setUnbreakable(true);
        armorHeadMeta.setColor(Color.fromRGB(0,51,141));
        armorHead.setItemMeta(armorHeadMeta);

        ItemStack swordHand = new ItemStack(Material.STONE_PICKAXE,1);

        this.setItemSlot(EquipmentSlot.MAINHAND, CraftItemStack.asNMSCopy(swordHand));
        this.setItemSlot(EquipmentSlot.HEAD,CraftItemStack.asNMSCopy(armorHead));
        this.setDropChance(EquipmentSlot.HEAD, 0);

        this.goalSelector.removeAllGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1D, true));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.7D));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this, 0.7D));
        this.setHealth(5);
    }
}

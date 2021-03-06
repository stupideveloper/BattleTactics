package dev.tenfov.battletactics.mobs.zombie;

import net.minecraft.world.entity.ai.goal.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Zombie;

public class BaseZombie extends Zombie {
    private Float DesiredHealth;
    public BaseZombie(Location loc) {
        super(EntityType.ZOMBIE,((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());
        /**
         * Sets the custom name
         * ChatColor.{Color Name} to set custom colors, 
         */
        this.setCustomName(new TextComponent("" + ChatColor.BOLD  + ChatColor.YELLOW + "Undead"));
        this.setCustomNameVisible(true);

        /**
         * set this to the desired health of the mob
         */
        this.DesiredHealth = Float.valueOf(50);

        // Equip Items
        /**
         * change the required items, using Material.{ITEMNAME}
         */
        ItemStack armorHead = new ItemStack(Material.IRON_HELMET,1);
        armorHead.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);

        ItemStack armorChest = new ItemStack(Material.CHAINMAIL_CHESTPLATE,1);
        armorChest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);

        ItemStack armorLegs = new ItemStack(Material.IRON_LEGGINGS,1);
        armorLegs.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);

        ItemStack armorBoots = new ItemStack(Material.IRON_BOOTS,1);
        armorBoots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);

        ItemStack swordHand = new ItemStack(Material.IRON_SWORD,1);
        swordHand.addEnchantment(Enchantment.DAMAGE_ALL, 5);

        ItemStack offHand = new ItemStack(Material.IRON_SWORD,1);
        swordHand.addEnchantment(Enchantment.DAMAGE_ALL, 5);
        /**
         * comment out the armor slots not being used for the mob
         */
        this.setItemSlot(EquipmentSlot.OFFHAND, CraftItemStack.asNMSCopy(offHand));
        this.setItemSlot(EquipmentSlot.MAINHAND, CraftItemStack.asNMSCopy(swordHand));
        this.setItemSlot(EquipmentSlot.HEAD,CraftItemStack.asNMSCopy(armorHead));
        this.setItemSlot(EquipmentSlot.CHEST,CraftItemStack.asNMSCopy(armorChest));
        this.setItemSlot(EquipmentSlot.LEGS,CraftItemStack.asNMSCopy(armorLegs));
        this.setItemSlot(EquipmentSlot.FEET,CraftItemStack.asNMSCopy(armorBoots));
        this.setDropChance(EquipmentSlot.OFFHAND, 0);
        this.setDropChance(EquipmentSlot.MAINHAND, 0);
        this.setDropChance(EquipmentSlot.HEAD, 0);
        this.setDropChance(EquipmentSlot.CHEST, 0);
        this.setDropChance(EquipmentSlot.LEGS, 0);
        this.setDropChance(EquipmentSlot.FEET, 0);

        /**
         * The AI for the mob
         * look at all available AIs and make a choice
         * if you see an error, you probably have invalid
         * arguments
         */
        this.goalSelector.removeAllGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.8D, true));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.3D));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));

        this.setAbsorptionAmount(this.DesiredHealth - this.getMaxHealth());
    }
}
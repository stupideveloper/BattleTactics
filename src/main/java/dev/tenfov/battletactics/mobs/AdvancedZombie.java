package dev.tenfov.battletactics.mobs;

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


public class AdvancedZombie extends Zombie {
    public AdvancedZombie(Location loc) {
        super(EntityType.ZOMBIE,((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());

        this.setCustomName(new TextComponent(ChatColor.BOLD + "" + ChatColor.RED + "Advanced Zombie"));
        this.setCustomNameVisible(true);

        // Equip Items
        ItemStack armorHead = new ItemStack(Material.LEATHER_HELMET,1);
        LeatherArmorMeta armorHeadMeta = (LeatherArmorMeta) armorHead.getItemMeta();
        armorHeadMeta.setUnbreakable(true);
        armorHeadMeta.setColor(Color.fromRGB(255,13,13));
        armorHead.setItemMeta(armorHeadMeta);

        ItemStack swordHand = new ItemStack(Material.STONE_SWORD,1);

        this.setItemSlot(EquipmentSlot.MAINHAND, CraftItemStack.asNMSCopy(swordHand));
        this.setItemSlot(EquipmentSlot.HEAD,CraftItemStack.asNMSCopy(armorHead));
        this.setDropChance(EquipmentSlot.HEAD, 0);

        this.goalSelector.removeAllGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5D, true));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1D));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));

        this.setAbsorptionAmount(4);
    }
}

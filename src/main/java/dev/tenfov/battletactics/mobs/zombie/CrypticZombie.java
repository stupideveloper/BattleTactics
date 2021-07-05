package dev.tenfov.battletactics.mobs.zombie;



import net.minecraft.world.entity.ai.goal.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;


import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Zombie;



public class CrypticZombie extends Zombie {
    public CrypticZombie(Location loc) {
        super(EntityType.ZOMBIE,((CraftWorld) loc.getWorld()).getHandle());
        this.setPos(loc.getX(), loc.getY(), loc.getZ());

        this.setCustomName(new TextComponent(ChatColor.BOLD + "" + ChatColor.DARK_PURPLE + "Cryptic Zombie"));
        this.setCustomNameVisible(true);

        // Equip Items
        ItemStack armorHead = new ItemStack(Material.IRON_HELMET,1);

        ItemStack swordHand = new ItemStack(Material.IRON_SWORD,1);

        this.setItemSlot(EquipmentSlot.MAINHAND, CraftItemStack.asNMSCopy(swordHand));
        this.setItemSlot(EquipmentSlot.HEAD,CraftItemStack.asNMSCopy(armorHead));
        this.setDropChance(EquipmentSlot.HEAD, 0);

        this.goalSelector.removeAllGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.6D, true));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));

        this.setAbsorptionAmount(6);
    }
}

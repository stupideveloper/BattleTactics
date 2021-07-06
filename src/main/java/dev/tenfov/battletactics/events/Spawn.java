package dev.tenfov.battletactics.events;

import dev.tenfov.battletactics.sphere;
import dev.tenfov.battletactics.mobs.healthbar.HealthBarEntity;
import dev.tenfov.battletactics.mobs.skeleton.*;
import dev.tenfov.battletactics.mobs.zombie.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class Spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                return false;
            }
            Player player = (Player) sender;
            int times = 1;
            if (args.length == 2) {
                try {
                    times = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    times = 1;
                }
            } else if (args.length == 1) {
                times = 1;
            }
            if ((args.length < 3)) {
                player.sendMessage(ChatColor.YELLOW + "Summoning " + args[0]);
            }
            if ((args.length == 2)) {
                player.sendMessage(ChatColor.YELLOW + "Summoning " + args[1] + args[0]);
                for (int i = 0; i < times; i++) {
                    if (args[0].equalsIgnoreCase("gabe")) {
                        Gabe ZombieSpawn = new Gabe(player.getLocation());
                        HealthBarEntity bar = new HealthBarEntity(player.getLocation(),ZombieSpawn);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(bar,SpawnReason.COMMAND);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(ZombieSpawn,SpawnReason.COMMAND);
                    }
                    else if (args[0].equalsIgnoreCase("zombie")) {
                        BasicZombie ZombieSpawn = new BasicZombie(player.getLocation());
                        HealthBarEntity bar = new HealthBarEntity(player.getLocation(),ZombieSpawn);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(bar,SpawnReason.COMMAND);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(ZombieSpawn,SpawnReason.COMMAND);
                    }
                    else if (args[0].equalsIgnoreCase("advanced_zombie")) {
                        AdvancedZombie ZombieSpawn = new AdvancedZombie(player.getLocation());
                        HealthBarEntity bar = new HealthBarEntity(player.getLocation(),ZombieSpawn);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(bar,SpawnReason.COMMAND);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(ZombieSpawn,SpawnReason.COMMAND);
                    }
                    else if (args[0].equalsIgnoreCase("enhanced_zombie")) {
                        EnhancedZombie ZombieSpawn = new EnhancedZombie(player.getLocation());
                        HealthBarEntity bar = new HealthBarEntity(player.getLocation(),ZombieSpawn);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(bar,SpawnReason.COMMAND);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(ZombieSpawn,SpawnReason.COMMAND);
                    }
                    else if (args[0].equalsIgnoreCase("cryptic_zombie")) {
                        CrypticZombie ZombieSpawn = new CrypticZombie(player.getLocation());
                        HealthBarEntity bar = new HealthBarEntity(player.getLocation(),ZombieSpawn);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(bar,SpawnReason.COMMAND);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(ZombieSpawn,SpawnReason.COMMAND);
                    }
                    else if (args[0].equalsIgnoreCase("undead_zombie")) {
                        UndeadZombie ZombieSpawn = new UndeadZombie(player.getLocation());
                        HealthBarEntity bar = new HealthBarEntity(player.getLocation(),ZombieSpawn);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(bar,SpawnReason.COMMAND);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(ZombieSpawn,SpawnReason.COMMAND);
                    }
                    else if (args[0].equalsIgnoreCase("josephi")) {
                        Josephi SkeletonSpawn = new Josephi(player.getLocation());
                        HealthBarEntity bar = new HealthBarEntity(player.getLocation(),SkeletonSpawn);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(bar,SpawnReason.COMMAND);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(SkeletonSpawn,SpawnReason.COMMAND);
                    } else if (args[0].equalsIgnoreCase("skeleton_master")) {
                        SkeleMaster SkeletonSpawn = new SkeleMaster(player.getLocation());
                        HealthBarEntity bar = new HealthBarEntity(player.getLocation(),SkeletonSpawn);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(bar,SpawnReason.COMMAND);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(SkeletonSpawn,SpawnReason.COMMAND);
                    } else if (args[0].equalsIgnoreCase("sphere_test")) {
                        new sphere(player.getLocation(),(double) 4);
                    } else {
                        player.sendMessage(ChatColor.YELLOW + "Mob does not exist.");
                    }
                }
            } else {
                player.sendMessage(ChatColor.YELLOW + "Please include a number of mobs to spawn. /mobspawn <mob> <amount>");
            }
        }
        return true;
    }
}
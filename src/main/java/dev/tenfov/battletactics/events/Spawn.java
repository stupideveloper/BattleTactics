package dev.tenfov.battletactics.events;

import dev.tenfov.battletactics.mobs.skeleton.Josephi;
import dev.tenfov.battletactics.mobs.skeleton.SkeleMaster;
import dev.tenfov.battletactics.mobs.spider.BasicCaveSpider;
import dev.tenfov.battletactics.mobs.spider.BasicSpider;
import dev.tenfov.battletactics.sphere;
import dev.tenfov.battletactics.mobs.healthbar.HealthBarEntity;
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
                player.sendMessage(ChatColor.YELLOW + "Summoning " + args[1] + "x " +args[0]);
                Boolean shouldParticle = false;
                Boolean hasSpawnedOne = false;
                for (int i = 0; i < times; i++) {
                    if (args[0].equalsIgnoreCase("gabe")) {
                        shouldParticle = true;
                        Gabe ZombieSpawn = new Gabe(player.getLocation());
                        HealthBarEntity bar = new HealthBarEntity(player.getLocation(),ZombieSpawn);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(bar,SpawnReason.COMMAND);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(ZombieSpawn,SpawnReason.COMMAND);
                    }
                    else if (args[0].equalsIgnoreCase("zombie")) {
                        shouldParticle = true;
                        BasicZombie ZombieSpawn = new BasicZombie(player.getLocation());
                        HealthBarEntity bar = new HealthBarEntity(player.getLocation(),ZombieSpawn);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(bar,SpawnReason.COMMAND);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(ZombieSpawn,SpawnReason.COMMAND);
                    }
                    else if (args[0].equalsIgnoreCase("advanced_zombie")) {
                        shouldParticle = true;
                        AdvancedZombie ZombieSpawn = new AdvancedZombie(player.getLocation());
                        HealthBarEntity bar = new HealthBarEntity(player.getLocation(),ZombieSpawn);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(bar,SpawnReason.COMMAND);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(ZombieSpawn,SpawnReason.COMMAND);
                    }
                    else if (args[0].equalsIgnoreCase("enhanced_zombie")) {
                        shouldParticle = true;
                        EnhancedZombie ZombieSpawn = new EnhancedZombie(player.getLocation());
                        HealthBarEntity bar = new HealthBarEntity(player.getLocation(),ZombieSpawn);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(bar,SpawnReason.COMMAND);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(ZombieSpawn,SpawnReason.COMMAND);
                    }
                    else if (args[0].equalsIgnoreCase("cryptic_zombie")) {
                        shouldParticle = true;
                        CrypticZombie ZombieSpawn = new CrypticZombie(player.getLocation());
                        HealthBarEntity bar = new HealthBarEntity(player.getLocation(),ZombieSpawn);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(bar,SpawnReason.COMMAND);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(ZombieSpawn,SpawnReason.COMMAND);
                    }
                    else if (args[0].equalsIgnoreCase("undead_zombie")) {
                        shouldParticle = true;
                        UndeadZombie ZombieSpawn = new UndeadZombie(player.getLocation());
                        HealthBarEntity bar = new HealthBarEntity(player.getLocation(),ZombieSpawn);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(bar,SpawnReason.COMMAND);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(ZombieSpawn,SpawnReason.COMMAND);
                    }
                    else if (args[0].equalsIgnoreCase("undead")) {
                        shouldParticle = true;
                        UndeadZombie ZombieSpawn = new UndeadZombie(player.getLocation());
                        HealthBarEntity bar = new HealthBarEntity(player.getLocation(),ZombieSpawn);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(bar,SpawnReason.COMMAND);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(ZombieSpawn,SpawnReason.COMMAND);
                    }
                    else if (args[0].equalsIgnoreCase("josephi")) {
                        shouldParticle = true;
                        Josephi SkeletonSpawn = new Josephi(player.getLocation());
                        HealthBarEntity bar = new HealthBarEntity(player.getLocation(),SkeletonSpawn);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(bar,SpawnReason.COMMAND);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(SkeletonSpawn,SpawnReason.COMMAND);
                    } else if (args[0].equalsIgnoreCase("skeleton_master")) {
                        shouldParticle = true;
                        SkeleMaster SkeletonSpawn = new SkeleMaster(player.getLocation());
                        HealthBarEntity bar = new HealthBarEntity(player.getLocation(),SkeletonSpawn);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(bar,SpawnReason.COMMAND);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(SkeletonSpawn,SpawnReason.COMMAND);

                    } else if (args[0].equalsIgnoreCase("spider")) {
                        shouldParticle = true;
                        BasicSpider SpiderSpawn = new BasicSpider(player.getLocation());
                        HealthBarEntity bar = new HealthBarEntity(player.getLocation(),SpiderSpawn);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(bar,SpawnReason.COMMAND);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(SpiderSpawn,SpawnReason.COMMAND);

                    }  else if (args[0].equalsIgnoreCase("cave_spider")) {
                        shouldParticle = true;
                        BasicCaveSpider SpiderSpawn = new BasicCaveSpider(player.getLocation());
                        HealthBarEntity bar = new HealthBarEntity(player.getLocation(),SpiderSpawn);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(bar,SpawnReason.COMMAND);
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(SpiderSpawn,SpawnReason.COMMAND);

                    } else if (args[0].equalsIgnoreCase("sphere_test")) {
                        if (!hasSpawnedOne) {
                        hasSpawnedOne = true;
                        new sphere(player.getLocation(),(double) 1);
                        }
                    } else {
                        player.sendMessage(ChatColor.YELLOW + "Mob does not exist.");
                    }
                }
                if (shouldParticle) {
                    new sphere(player.getLocation(),(double) 1, (double) 2, (double) 1);
                }
            } else {
                player.sendMessage(ChatColor.YELLOW + "Please include a number of mobs to spawn. /mobspawn <mob> <amount>");
            }
        }
        return true;
    }
}
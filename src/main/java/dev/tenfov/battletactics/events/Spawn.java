package dev.tenfov.battletactics.events;

import dev.tenfov.battletactics.mobs.skeleton.Josephi;
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
            Player player = (Player) sender;
            int times = 1;
            if (args.length == 2) {
                try {
                    times = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    times = 1;
                }
            }
            if ((args.length == 2)) {
                player.sendMessage(ChatColor.YELLOW + "Summoning " + args[1] + args[0]);
                for (int i = 0; i < times; i++) {
                    if (args[0].equalsIgnoreCase("gabe")) {
                        Gabe ZombieSpawn = new Gabe(player.getLocation());
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(ZombieSpawn,SpawnReason.COMMAND);
                    }
                    else if (args[0].equalsIgnoreCase("zombie")) {
                        BasicZombie ZombieSpawn = new BasicZombie(player.getLocation());
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(ZombieSpawn,SpawnReason.COMMAND);
                    }
                    else if (args[0].equalsIgnoreCase("advancedzombie")) {
                        AdvancedZombie ZombieSpawn = new AdvancedZombie(player.getLocation());
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(ZombieSpawn,SpawnReason.COMMAND);
                    }
                    else if (args[0].equalsIgnoreCase("enhancedzombie")) {
                        EnhancedZombie ZombieSpawn = new EnhancedZombie(player.getLocation());
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(ZombieSpawn,SpawnReason.COMMAND);
                    }
                    else if (args[0].equalsIgnoreCase("crypticzombie")) {
                        CrypticZombie ZombieSpawn = new CrypticZombie(player.getLocation());
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(ZombieSpawn,SpawnReason.COMMAND);
                    }
                    else if (args[0].equalsIgnoreCase("josephi")) {
                        Josephi SkeletonSpawn = new Josephi(player.getLocation());
                        ((CraftWorld) player.getWorld()).getHandle().addEntity(SkeletonSpawn,SpawnReason.COMMAND);
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

package dev.tenfov.battletactics.events;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import dev.tenfov.battletactics.mobs.Gabe;

public class Spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Gabe dirtyJoe = new Gabe(player.getLocation());
            ((CraftWorld) player.getWorld()).getHandle().addEntity(dirtyJoe,SpawnReason.COMMAND);
        }
        return true;
    }
}

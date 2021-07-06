package dev.tenfov.battletactics.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().setResourcePack("https://www.dropbox.com/s/hpd705war283fhx/Jicklus%2B1.17.zip?dl=1"); // Direct Download to texture pack..
    }
}

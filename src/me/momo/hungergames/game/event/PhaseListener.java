package me.momo.hungergames.game.event;

import me.momo.hungergames.Core;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

/**
 * Contains generic methods to listen events for phases.
 */
public class PhaseListener implements Listener {

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        if (!Core.getPhaseManager().getCurrentPhase().canJoin()) {
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.DARK_RED + "Sorry, but you cannot join during " + Core.getPhaseManager().getCurrentPhase().getDisplayName() + ".");
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
        Core.getPhaseManager().getCurrentPhase().playerJoin(event.getPlayer());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        event.setQuitMessage(null);
        Core.getPhaseManager().getCurrentPhase().playerLeave(event.getPlayer());
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (!Core.getPhaseManager().getCurrentPhase().canMove())
            event.getPlayer().teleport(new Location
                    (event.getFrom().getWorld(), event.getFrom().getX(), event.getFrom().getY(), event.getFrom().getZ()));
    }
}

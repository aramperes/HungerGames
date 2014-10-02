package me.momo.hungergames.game.event;

import me.momo.hungergames.Core;
import me.momo.hungergames.game.SimpleAntiCheat;
import me.momo.hungergames.game.cheat.CheatType;
import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * Contains events to listen for the Anti-Cheat class
 */
public class CheatListener implements Listener {

    @EventHandler
    public void reachCheck(EntityDamageByEntityEvent event) {
        if (event.getDamager().getType()== EntityType.PLAYER) {
            Player player = (Player)event.getDamager();

            if (player.getGameMode()== GameMode.CREATIVE)
                return;

            if (event.getDamager().getLocation().distance(event.getEntity().getLocation()) > SimpleAntiCheat.getReachDistance()) {
                Core.getAntiCheat().warnPlayer(player, CheatType.REACH);
                event.setCancelled(true);
            }
        }
    }
}

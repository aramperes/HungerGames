package me.momo.hungergames.game.event;

import me.momo.hungergames.Core;
import me.momo.hungergames.game.SimpleAntiCheat;
import me.momo.hungergames.game.cheat.CheatType;
import me.momo.hungergames.game.player.PlayerProfile;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 * Contains events to listen for the Anti-Cheat class
 */
public class CheatListener implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void swearCheck(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (event.getMessage().contains("swear")) { // Pseudo
            Core.getAntiCheat().warnPlayer(player, CheatType.SWEARING);
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void blockGlitchCheck(BlockBreakEvent event) {
        if (event.getPlayer() == null)
            return;
        PlayerProfile profile = Core.getPlayerProfiles().get(event.getPlayer().getUniqueId());
        if (profile.getType().isCheatProof())
            return;
        // if (Core.getAntiCheat.getAllowedBlocks().contains(event.getBlock.getType())
        //     return;

        if (Core.getPhaseManager().getCurrentPhase().getId() == 3) {
            event.setCancelled(true);
            Core.getAntiCheat().warnPlayer(event.getPlayer(), CheatType.BLOCKGLITCH);
        }
    }

    @EventHandler (priority = EventPriority.HIGH)
    public void spamCheck(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        long time = System.currentTimeMillis();
        long lastMessage = Core.getPlayerProfiles().get(player.getUniqueId()).getLastChat();
        long chatTime = time-lastMessage;
        if (lastMessage == -1) {
            lastMessage = time - ((long)SimpleAntiCheat.getFloodTime()*2);
        }
        Core.getPlayerProfiles().get(player.getUniqueId()).setLastChat(time);

        if (chatTime < SimpleAntiCheat.getFloodTime()) {
            event.setCancelled(true);
            Core.getAntiCheat().warnPlayer(player, CheatType.SPAM);
        }
    }

    @EventHandler
    public void reachCheck(EntityDamageByEntityEvent event) {

        if (event.getDamager().getType() == EntityType.PLAYER) {

            Player player = (Player) event.getDamager();

            PlayerProfile profile = Core.getPlayerProfiles().get(player.getUniqueId());
            if (profile.getType().isCheatProof())
                return;

            if (player.getGameMode() == GameMode.CREATIVE)
                return;

            if (event.getDamager().getLocation().distance(event.getEntity().getLocation()) > SimpleAntiCheat.getReachDistance()) {
                Core.getAntiCheat().warnPlayer(player, CheatType.REACH);
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void regenCheck(EntityRegainHealthEvent event) {
        if (event.getEntityType() != EntityType.PLAYER)
            return;

        if (event.getRegainReason() != EntityRegainHealthEvent.RegainReason.SATIATED)
            return;

        Player player = (Player) event.getEntity(); // The player we are looking into
        PlayerProfile profile = Core.getPlayerProfiles().get(player.getUniqueId());
        if (profile.getType().isCheatProof())
            return;
        long time = System.currentTimeMillis(); // The current time on the server
        long lastHeal = 0; // The last heal where the player regenerated
        lastHeal = Core.getPlayerProfiles().get(player.getUniqueId()).getLastHeal();
        long healTime = (time - lastHeal); // The difference between the last heal and the time.

        if (lastHeal == -1) { // By default, a profile has a last heal of -1
            lastHeal = time - (5 * 1000);
        }

        Core.getPlayerProfiles().get(player.getUniqueId()).setLastHeal(time); // We update the last heal

        /*
         * A check if the player is regenerating when it cannot because of the food level.
         */
        if (player.getFoodLevel() <= 17) {
            Core.getAntiCheat().warnPlayer(player, CheatType.REGEN);
            event.setCancelled(true);
            return;
        }
         /*
          * We check the difference of time between the last heal and the current time.
          */
        if (healTime < (SimpleAntiCheat.getRegenTimeBetweenHeals()) && (healTime != 0)) {
            Core.getAntiCheat().warnPlayer(player, CheatType.REGEN);
            event.setCancelled(true);
            return;
        }
    }
}

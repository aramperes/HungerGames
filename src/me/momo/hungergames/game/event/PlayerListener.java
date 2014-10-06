package me.momo.hungergames.game.event;

import me.momo.hungergames.Core;
import me.momo.hungergames.game.player.PlayerProfile;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Simple player listeners.
 */
public class PlayerListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        PlayerProfile profile = Core.getPlayerProfiles().get(player.getUniqueId());
        event.setCancelled(true);
        if (!profile.getType().isAlive()) {
            for (PlayerProfile profiles : Core.getPlayerProfiles().values()) {
                if (!profiles.getType().isAlive())
                    Bukkit.getPlayer(profile.getUniqueID()).sendMessage(profiles.getType().getPrefix() + event.getMessage());
            }
        } else {
            for (PlayerProfile profiles : Core.getPlayerProfiles().values()) {
                Bukkit.getPlayer(profile.getUniqueID()).sendMessage(profiles.getType().getPrefix() + event.getMessage());
            }
        }

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (!Core.getPlayerProfiles().containsKey(event.getPlayer().getUniqueId())) {
            PlayerProfile profile = new PlayerProfile(event.getPlayer().getUniqueId());
            Core.getPlayerProfiles().put(event.getPlayer().getUniqueId(), profile);
        }
    }
}

package me.momo.hungergames.game.event;

import me.momo.hungergames.Core;
import me.momo.hungergames.game.player.PlayerProfile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Simple player listeners.
 */
public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (!Core.getPlayerProfiles().containsKey(event.getPlayer().getUniqueId())) {
            PlayerProfile profile = new PlayerProfile(event.getPlayer().getUniqueId());
            Core.getPlayerProfiles().put(event.getPlayer().getUniqueId(), profile);
        }
    }
}

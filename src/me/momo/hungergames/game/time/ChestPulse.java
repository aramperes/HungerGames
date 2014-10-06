package me.momo.hungergames.game.time;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

/**
 * Single pulse for chest updated (anti chest finder)
 */
public class ChestPulse implements Runnable {
    private List<Location> chests;

    public ChestPulse(Location... chests) {
        this.chests = Arrays.asList(chests);
    }

    @Override
    public void run() {
        double distance = 30d;
        for (Location location : chests) {
            boolean shouldShow = false;
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.getLocation().distance(location) <= distance) {
                    shouldShow = true;
                    break;
                }
            }
            if (!shouldShow) {
                location.getBlock().setType(Material.AIR);
            } else {
                location.getBlock().setType(Material.CHEST);
            }
        }
    }
}

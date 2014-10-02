package me.momo.hungergames.game;

import me.momo.hungergames.Core;
import me.momo.hungergames.game.cheat.CheatType;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * A simple anti-cheat system
 */
public class SimpleAntiCheat {
    private Core core;
    private static double reachDistance = 5d;

    public SimpleAntiCheat(Core core) {
        this.core = core;
    }

    public void warnPlayer(Player player, CheatType type) {
        player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + ChatColor.STRIKETHROUGH + "=========================");
        player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You have been warned for " + ChatColor.RESET + ChatColor.GOLD + type.getDisplayName());
        player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + ChatColor.STRIKETHROUGH + "=========================");
    }

    public static double getReachDistance() {
        return reachDistance;
    }
}

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
    private static double regenTimeBetweenHeals = 3.8*1000;
    private static double floodTime = 0.3 * 1000;
    private static int maxVL = 8;

    public SimpleAntiCheat(Core core) {
        this.core = core;
    }

    public void warnPlayer(Player player, CheatType type) {
        Core.getPlayerProfiles().get(player.getUniqueId()).addCheat(type);
        player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + ChatColor.STRIKETHROUGH + "=========================");
        player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "CHEATING DETECTED");
        player.sendMessage(ChatColor.DARK_RED + "You have been warned for " + ChatColor.GOLD + type.getDisplayName() + " (VL " + type.getLevel() + ")");
        player.sendMessage(ChatColor.DARK_AQUA + "If you continue cheating on this server you will be kicked from the game.");
        player.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.ITALIC + "Reaching a VL of " + getMaxVL() + " will result a kick (" + (getMaxVL() - Core.getPlayerProfiles().get(player.getUniqueId()).getViolationLevel()) + " left).");
        player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + ChatColor.STRIKETHROUGH + "=========================");
    }

    public static double getReachDistance() {
        return reachDistance;
    }

    public static double getRegenTimeBetweenHeals() {
        return regenTimeBetweenHeals;
    }

    public static double getFloodTime() {
        return floodTime;
    }

    public static int getMaxVL() {
        return maxVL;
    }
}

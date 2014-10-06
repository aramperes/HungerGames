package me.momo.hungergames.game.player;

import org.bukkit.ChatColor;

/**
 * Tribute types.
 */
public enum TributeType {
    ALIVE(ChatColor.DARK_GRAY + " [" + ChatColor.LIGHT_PURPLE + "Tribute" + ChatColor.DARK_GRAY + "] " + ChatColor.RESET, true, false, false),
    SPECTATOR(ChatColor.DARK_GRAY + " [" + ChatColor.DARK_AQUA + "Spectator" + ChatColor.DARK_GRAY + "] " + ChatColor.RESET, false, true, true),
    DEAD(ChatColor.DARK_GRAY + " [" + ChatColor.DARK_PURPLE + "Dead" + ChatColor.DARK_GRAY + "] " + ChatColor.RESET, false, true, true);

    private String prefix;
    private boolean alive;
    private boolean fly;
    private boolean cheatProof;

    TributeType(String prefix, boolean alive, boolean fly, boolean cheatProof) {
        this.prefix = prefix;
        this.alive = alive;
        this.fly = fly;
        this.cheatProof = cheatProof;
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isFly() {
        return fly;
    }

    public boolean isCheatProof() {
        return cheatProof;
    }
}

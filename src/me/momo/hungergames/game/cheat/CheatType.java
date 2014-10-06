package me.momo.hungergames.game.cheat;

/**
 * Created by Momo in 10 2014.
 */
public enum CheatType {
    SPEED(0, 1, "Speed Hacking"),
    FLIGHT(1, 3, "Flight"),
    SPAM(2, 1, "Flooding"),
    REACH(3, 2, "Reach"),
    REGEN(4, 2, "Regen"),
    FORCEFIELD(5, 2, "KillAura");

    private int id;
    private int level;
    private String displayName;

    CheatType(int id, int level, String displayName) {
        this.id = id;
        this.level = level;
        this.displayName = displayName;
    }

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public String getDisplayName() {
        return displayName;
    }
}

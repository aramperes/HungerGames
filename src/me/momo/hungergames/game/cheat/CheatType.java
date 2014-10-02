package me.momo.hungergames.game.cheat;

/**
 * Created by Momo in 10 2014.
 */
public enum CheatType {
    SPEED(0, 1, "SpeedHacks"),
    FLIGHT(1, 3, "Flight"),
    SPAM(2, 1, "Spamming"),
    REACH(3, 2, "Reach"),;

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

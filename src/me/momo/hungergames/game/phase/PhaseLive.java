package me.momo.hungergames.game.phase;

import me.momo.hungergames.Core;
import me.momo.hungergames.util.MsgUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Represents the Live phase (in-game)
 */
public class PhaseLive implements Phase {
    int ticks = 0;

    @Override
    public int getId() {
        return 3;
    }

    @Override
    public String getDisplayName() {
        return "Live Game";
    }

    @Override
    public int getMaxTicks() {
        return 30 * 60;
    }

    @Override
    public int getTicks() {
        return ticks;
    }

    @Override
    public boolean isInfinite() {
        return false;
    }

    @Override
    public boolean isPvP() {
        return true;
    }

    @Override
    public boolean canJoin() {
        return true;
    }

    @Override
    public boolean canMove() {
        return true;
    }

    @Override
    public void playerJoin(Player player) {
        // TODO: Spectator
    }

    @Override
    public void playerLeave(Player player) {
        // TODO: Eliminate player if tribute
    }

    @Override
    public void startPhase() {
        Core.sendGlobalMessage(ChatColor.DARK_GRAY + " [" + ChatColor.LIGHT_PURPLE + "Tributes" + ChatColor.DARK_GRAY + "] " + ChatColor.GREEN + ""
                + ChatColor.BOLD + "THE GAMES HAVE BEGUN! " + ChatColor.DARK_GREEN + "GOOD LUCK TRIBUTES");
    }

    @Override
    public void endPhase() {

    }

    @Override
    public void pulse() {
        if (ticks == getMaxTicks()) {
            endPhase();
        } else {
            ticks--;
        }
    }
}

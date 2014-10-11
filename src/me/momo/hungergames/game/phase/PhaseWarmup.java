package me.momo.hungergames.game.phase;

import me.momo.hungergames.Core;
import me.momo.hungergames.util.MsgUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Represents the Warmup phase (transition between lobby and in-game).
 */
public class PhaseWarmup implements Phase {
    int ticks = 0;

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public String getDisplayName() {
        return "Warm-Up";
    }

    @Override
    public int getMaxTicks() {
        return 30;
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
        return false;
    }

    @Override
    public boolean canJoin() {
        return false;
    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public void playerJoin(Player player) {
        // Unused
    }

    @Override
    public void playerLeave(Player player) {
        // Unused
    }

    @Override
    public void startPhase() {

        Core.sendGlobalMessage(ChatColor.DARK_GRAY + " [" + ChatColor.AQUA + "Game" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + ""
                + ChatColor.BOLD + "TELEPORTING TRIBUTES TO MAP...");
        Core.sendGlobalMessage(ChatColor.DARK_GRAY + " [" + ChatColor.AQUA + "Game" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + ""
                + ChatColor.BOLD + "THE GAMES WILL START IN 30 SECONDS. " + ChatColor.WHITE + "Get ready!");

    }

    @Override
    public void endPhase() {
        Core.getPhaseManager().setCurrentPhase(new PhaseLive());
    }

    @Override
    public void pulse() {
        if (ticks == getMaxTicks()) {
            endPhase();
        } else {
            ticks++;
            int timeLeft = MsgUtil.invertTime(getMaxTicks(), getTicks());
            if ((timeLeft < 5 || timeLeft == 10) && timeLeft > 0) {
                Core.sendGlobalMessage(ChatColor.DARK_GRAY + " [" + ChatColor.YELLOW + "Time" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + ""
                        + ChatColor.BOLD + "GAME STARTING IN " + ChatColor.WHITE + MsgUtil.longTime(timeLeft).toUpperCase());
            }
        }
    }
}

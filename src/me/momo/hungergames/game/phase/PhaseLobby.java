package me.momo.hungergames.game.phase;

import me.momo.hungergames.Core;
import me.momo.hungergames.util.MsgUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Represents the Lobby phase (waiting for players/map vote)
 */
public class PhaseLobby implements Phase {
    int ticks = 0;

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public String getDisplayName() {
        return "Lobby";
    }

    @Override
    public int getMaxTicks() {
        return 120;
    }

    @Override
    public int getTicks() {
        return ticks;
    }

    public void setTicks(int ticks) {
        this.ticks = ticks;
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
        return true;
    }

    @Override
    public boolean canMove() {
        return true;
    }

    @Override
    public void playerJoin(Player player) {
        // TODO: Join message
    }

    @Override
    public void playerLeave(Player player) {
        // TODO: Leave message
    }

    @Override
    public void startPhase() {

    }

    @Override
    public void endPhase() {
        Core.getPhaseManager().setCurrentPhase(new PhaseWarmup());
    }

    @Override
    public void pulse() {
        if (ticks == getMaxTicks()) {
            endPhase();
        } else {
            ticks++;
            int timeLeft = MsgUtil.invertTime(getMaxTicks(), getTicks());
            if ((timeLeft%30==0 || timeLeft <= 10) && timeLeft > 0) {
                Core.sendGlobalMessage(ChatColor.DARK_GRAY + " [" + ChatColor.YELLOW + "Time" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + ""
                        + ChatColor.BOLD + "LOBBY ENDING IN " + ChatColor.WHITE + MsgUtil.longTime(timeLeft).toUpperCase());
            }
        }
    }
}

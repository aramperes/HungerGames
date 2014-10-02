package me.momo.hungergames.game.phase;

import me.momo.hungergames.Core;
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
        return 10;
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
        }
    }
}

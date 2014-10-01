package me.momo.hungergames.game.phase;

import me.momo.hungergames.Core;

/**
 * Copyright MOMOTHEREAL (c) 2014.
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
        }
    }
}

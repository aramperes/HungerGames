package me.momo.hungergames.game;

/**
 * Copyright MOMOTHEREAL (c) 2014.
 */
public class PhaseSettingUp implements Phase {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getDisplayName() {
        return "Setting Up";
    }

    @Override
    public int getMaxTicks() {
        return 0; // Unused
    }

    @Override
    public int getTicks() {
        return 0; // Unused
    }

    @Override
    public boolean isInfinite() {
        return true;
    }

    @Override
    public boolean isPvP() {
        return false;
    }

    @Override
    public boolean canMove() {
        return true;
    }

    @Override
    public void startPhase() {
        // TODO: Load maps and stuff
    }

    @Override
    public void endPhase() {
        // TODO: Switch to Lobby phase
    }

    @Override
    public void pulse() {
        // Unused
    }
}

package me.momo.hungergames.game;

import me.momo.hungergames.Core;

/**
 * Copyright MOMOTHEREAL (c) 2014.
 */
public class PhaseManager {
    private Core plugin;
    private Phase currentPhase;

    public PhaseManager(Core plugin) {
        this.plugin = plugin;
    }

    public Phase getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentPhase(Phase currentPhase) {
        if (getCurrentPhase()!=null) {
            getCurrentPhase().endPhase();
        }
        this.currentPhase = currentPhase;
        currentPhase.startPhase();
    }
}

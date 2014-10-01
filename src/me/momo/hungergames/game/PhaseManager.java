package me.momo.hungergames.game;

import me.momo.hungergames.Core;
import me.momo.hungergames.game.phase.Phase;

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
        this.currentPhase = currentPhase;
        currentPhase.startPhase();
        plugin.getLogger().info("[" + this.getClass().getSimpleName() + "] Started phase " + currentPhase.getDisplayName() + " (" + currentPhase.getClass().getSimpleName() + ").");
    }

}

package me.momo.hungergames.game;

import me.momo.hungergames.Core;
import me.momo.hungergames.game.phase.Phase;
import me.momo.hungergames.util.MsgUtil;
import org.bukkit.ChatColor;

/**
 * Centralizes information and methods for phases.
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

    public void globalPulse() {
        getCurrentPhase().pulse();
        if (!getCurrentPhase().isInfinite()) {

        }
    }

    public void setCurrentPhase(Phase currentPhase) {
        this.currentPhase = currentPhase;
        currentPhase.startPhase();
        plugin.getLogger().info("[" + this.getClass().getSimpleName() + "] Started phase " + currentPhase.getDisplayName() + " (" + currentPhase.getClass().getSimpleName() + ").");
    }

}

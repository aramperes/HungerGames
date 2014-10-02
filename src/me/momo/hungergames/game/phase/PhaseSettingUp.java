package me.momo.hungergames.game.phase;

import me.momo.hungergames.Core;
import me.momo.hungergames.game.phase.Phase;
import org.bukkit.entity.Player;

/**
 * Represents the SettingUp phase (Setting up maps)
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
    public boolean canJoin() {
        return false;
    }

    @Override
    public boolean canMove() {
        return true;
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
        // TODO: Load maps and stuff
        endPhase();
    }

    @Override
    public void endPhase() {
        Core.getPhaseManager().setCurrentPhase(new PhaseLobby());
    }

    @Override
    public void pulse() {
        // Unused
    }
}

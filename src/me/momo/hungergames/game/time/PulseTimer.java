package me.momo.hungergames.game.time;

import me.momo.hungergames.Core;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Represents the job for a single pulse (20 ticks)
 */
public class PulseTimer extends BukkitRunnable {
    @Override
    public void run() {
        Core.getPhaseManager().globalPulse();
    }
}

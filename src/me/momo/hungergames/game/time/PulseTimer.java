package me.momo.hungergames.game.time;

import me.momo.hungergames.Core;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Momo in 10 2014.
 */
public class PulseTimer extends BukkitRunnable {
    @Override
    public void run() {
        if (Core.getPhaseManager().getCurrentPhase() != null) {
            Core.getPhaseManager().getCurrentPhase().pulse();
        }
    }
}

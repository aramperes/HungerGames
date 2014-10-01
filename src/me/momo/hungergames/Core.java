package me.momo.hungergames;

import me.momo.hungergames.game.PhaseManager;
import me.momo.hungergames.game.PhaseSettingUp;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Copyright MOMOTHEREAL (c) 2014.
 */
public class Core extends JavaPlugin {

    @Override
    public void onEnable() {
        // Let's start some stuff here
        PhaseManager phaseManager = new PhaseManager(this);
        phaseManager.setCurrentPhase(new PhaseSettingUp());
    }

    @Override
    public void onDisable() {
        // Let's end some stuff here
    }
}

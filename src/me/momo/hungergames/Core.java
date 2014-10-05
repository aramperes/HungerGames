package me.momo.hungergames;

import me.momo.hungergames.game.PhaseManager;
import me.momo.hungergames.game.SimpleAntiCheat;
import me.momo.hungergames.game.event.CheatListener;
import me.momo.hungergames.game.event.PhaseListener;
import me.momo.hungergames.game.event.PlayerListener;
import me.momo.hungergames.game.phase.PhaseLive;
import me.momo.hungergames.game.phase.PhaseSettingUp;
import me.momo.hungergames.game.player.PlayerProfile;
import me.momo.hungergames.game.time.PulseTimer;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Main class of the plugin.
 */
public class Core extends JavaPlugin {
    static PhaseManager phaseManager;
    static SimpleAntiCheat antiCheat;
    static HashMap<UUID, PlayerProfile> playerProfiles = new HashMap<UUID, PlayerProfile>();

    @Override
    public void onEnable() {
        // Let's start some stuff here
        startPulseTimer();
        registerListeners();
        phaseManager = new PhaseManager(this);
        phaseManager.setCurrentPhase(new PhaseLive());
        antiCheat = new SimpleAntiCheat(this);
    }

    @Override
    public void onDisable() {
        // Let's end some stuff here
    }

    public static SimpleAntiCheat getAntiCheat() {
        return antiCheat;
    }

    public void registerListeners() {
        this.getServer().getPluginManager().registerEvents(new PhaseListener(), this);
        this.getServer().getPluginManager().registerEvents(new CheatListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

    public static PhaseManager getPhaseManager() {
        return phaseManager;
    }

    public void startPulseTimer() {
        this.getServer().getScheduler().runTaskTimer(this, new PulseTimer(), 20l, 20l);
    }

    public static HashMap<UUID, PlayerProfile> getPlayerProfiles() {
        return playerProfiles;
    }
}

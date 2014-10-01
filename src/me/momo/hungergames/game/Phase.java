package me.momo.hungergames.game;

/**
 * Copyright MOMOTHEREAL (c) 2014.
 */
public interface Phase {

    /**
     * Represents the ID.
     * @return the identifier of the phase.
     */
    public int getId();

    /**
     * Represents the display name.
     * Only used locally (nothing by default)
     * @return the display name of the phase.
     */
    public String getDisplayName();

    /**
     * Represents the maximum ticks the phase can reach.
     * @return the max duration of the phase in ticks.
     */
    public int getMaxTicks();

    /**
     * Represents the current ticks of the phase.
     * @return the current occurred ticks of the phase.
     */
    public int getTicks();

    /**
     * Whether or not the phase is infinite (should never end automatically).
     * @return true if the phase should never end unless told so.
     */
    public boolean isInfinite();

    /**
     * Whether players can take damage from anything (including PvP) or not.
     * @return true if players can take damage.
     */
    public boolean isPvP();

    /**
     * Whether entities can move around or not.
     * @return true if entities can move around.
     */
    public boolean canMove();

    /**
     * Starts the phase.
     */
    public void startPhase();

    /**
     * Ends the phase.
     */
    public void endPhase();

    /**
     * A single pulse in the phase. Should pulse every tick (1/20 seconds).
     */
    public void pulse();
}

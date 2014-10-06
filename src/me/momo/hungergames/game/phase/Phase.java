package me.momo.hungergames.game.phase;

import org.bukkit.entity.Player;

/**
 * Represents a single phase.
 */
public interface Phase {



    /**
     * Represents the ID.
     *
     * @return the identifier of the phase.
     */
    public int getId();

    /**
     * Represents the display name.
     * Only used locally (nothing by default)
     *
     * @return the display name of the phase.
     */
    public String getDisplayName();

    /**
     * Represents the maximum ticks the phase can reach.
     *
     * @return the max duration of the phase in ticks.
     */
    public int getMaxTicks();

    /**
     * Represents the current ticks of the phase.
     *
     * @return the current occurred ticks of the phase.
     */
    public int getTicks();

    /**
     * Whether or not the phase is infinite (should never end automatically).
     *
     * @return true if the phase should never end unless told so.
     */
    public boolean isInfinite();

    /**
     * Whether players can take damage from anything (including PvP) or not.
     *
     * @return true if players can take damage.
     */
    public boolean isPvP();

    /**
     * Whether players can join the server or not during this phase.
     *
     * @return true if players can join during this phase.
     */
    public boolean canJoin();

    /**
     * Whether entities can move around or not.
     *
     * @return true if entities can move around.
     */
    public boolean canMove();

    /**
     * Launches when a player joins.
     *
     * @param player the player who joined.
     */
    public void playerJoin(Player player);

    /**
     * Launches when a player leaves.
     *
     * @param player the player who left.
     */
    public void playerLeave(Player player);

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

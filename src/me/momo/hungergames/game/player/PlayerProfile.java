package me.momo.hungergames.game.player;

import me.momo.hungergames.game.cheat.CheatType;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A single player profile. Contains combat information for anti-cheat and stats.
 */
public class PlayerProfile {
    private UUID uniqueID;
    private long lastHeal = -1;
    private long lastHit = -1;
    private long lastChat = -1;
    private int violationLevel = 0;
    private TributeType type;
    private List<CheatType> cheats;

    public PlayerProfile(UUID uniqueID) {
        this.uniqueID = uniqueID;
        cheats = new ArrayList<CheatType>();
    }

    public UUID getUniqueID() {
        return uniqueID;
    }

    public long getLastHeal() {
        return lastHeal;
    }

    public void setLastHeal(long lastHeal) {
        this.lastHeal = lastHeal;
    }

    public long getLastHit() {
        return lastHit;
    }

    public void setLastHit(int lastHit) {
        this.lastHit = lastHit;
    }

    public long getLastChat() {
        return lastChat;
    }

    public void setLastChat(long lastChat) {
        this.lastChat = lastChat;
    }

    public int getViolationLevel() {
        return violationLevel;
    }

    public void setViolationLevel(int violationLevel) {
        this.violationLevel = violationLevel;
        updateVL();
    }

    public void addViolationLevel(int violationLevel) {
        setViolationLevel(getViolationLevel() + violationLevel);
    }

    public List<CheatType> getCheats() {
        return cheats;
    }

    public void addCheat(CheatType cheatType) {
        if (!cheats.contains(cheatType)) {
            cheats.add(cheatType);
        }
        addViolationLevel(cheatType.getLevel());
    }

    public void updateVL() {
        if (violationLevel > 5) {
            String cheatMessage = "";
            for (int i = 0; i < cheats.size(); i++) {
                if (i != (cheats.size() - 1)) {
                    cheatMessage += cheats.get(i).getDisplayName() + ", ";
                } else {
                    cheatMessage += cheats.get(i).getDisplayName();
                }
            }
            Bukkit.getPlayer(uniqueID).kickPlayer("§4You have been kicked for cheating (§6" + cheatMessage + "§4)." +
                    "\n§cModerators have been warned.");
        }
    }

    public TributeType getType() {
        return type;
    }

    public void setType(TributeType type) {
        this.type = type;
    }
}

package me.momo.hungergames.util;

/**
 * Message utilities
 */
public class MsgUtil {

    /**
     * Translate the seconds into a numeric look (ex.: 3661 seconds = 01:01:01)
     */
    public static String numericTime(int seconds) {
        int minutes = seconds / 60;
        int hours = minutes / 60;
        seconds = seconds % 60;
        minutes = minutes % 60;

        if (hours > 0)
            return toNumberic(hours) + ":" + toNumberic(minutes) + ":" + toNumberic(seconds);

        return toNumberic(minutes) + ":" + toNumberic(seconds);
    }

    /**
     * Puts a number into a numeric look (ex.: 9 = 09)
     */
    private static String toNumberic(int i) {
        String res = "";
        if (i < 10) {
            res = "0" + i;
        } else {
            res = "" + i;
        }
        return res;
    }

    /**
     * Uses full-length words to demonstrate time. (ex.: 3661 = 1 hours 1 minutes 1 seconds)
     */
    public static String longTime(int seconds) {
        int minutes = seconds / 60;
        int hours = minutes / 60;
        seconds = seconds % 60;
        minutes = minutes % 60;

        if (hours > 0)
            return hours + " hours " + minutes + " minutes " + seconds + " seconds";

        if (minutes > 0)
            return minutes + " minutes " + seconds + " seconds";

        return seconds + " seconds";
    }

    /**
     * Uses one-letter abbreviations to demonstrate time. (ex.: 3661 = 1h 1m 1s)
     */
    public static String shortTime(int seconds) {
        int minutes = seconds / 60;
        int hours = minutes / 60;
        seconds = seconds % 60;
        minutes = minutes % 60;

        if (hours > 0)
            return hours + "h " + minutes + "m " + seconds + "s";

        if (minutes > 0)
            return minutes + "m " + seconds + "s";

        return seconds + "s";
    }

    public static int invertTime(int maxTime, int time) {
        return maxTime-time;
    }
}

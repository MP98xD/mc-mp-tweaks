package com.mp98xd.mptweaks.client;

import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;

public class Logger {

    private final static LogCategory LOG_CATEGORY = LogCategory.createCustom(Log.NAME, "mp-tweaks");

    public static void debug(String message) {
        Log.debug(LOG_CATEGORY, message);
    }

    public static void info(String message) {
        Log.info(LOG_CATEGORY, message);
    }

    public static void warn(String message) {
        Log.warn(LOG_CATEGORY, message);
    }

    public static void error(String message) {
        Log.error(LOG_CATEGORY, message);
    }

}

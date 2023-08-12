package com.mp98xd.mptweaks.client.HUD.impl;

import com.mp98xd.mptweaks.client.HUD.HUDItem;
import net.minecraft.client.MinecraftClient;

public class Coordinate extends HUDItem {

    private int precision = 1;

    private String format = "%.1f, %.1f, %.1f";

    @Override
    public String calculate(MinecraftClient client) {
        if (client.player != null) {
            return String.format(format,
                    client.player.getX(),
                    client.player.getY(),
                    client.player.getZ()
            );
        }

        return null;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;

        this.format = String.format("%%.%1$df, %%.%1$df, %%.%1$df", precision);
    }

}

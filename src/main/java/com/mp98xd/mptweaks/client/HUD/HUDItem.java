package com.mp98xd.mptweaks.client.HUD;

import net.minecraft.client.MinecraftClient;

public abstract class HUDItem {

    private boolean disabled = false;

    public boolean getDisabled() {
        return this.disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public abstract String calculate(MinecraftClient client);

}

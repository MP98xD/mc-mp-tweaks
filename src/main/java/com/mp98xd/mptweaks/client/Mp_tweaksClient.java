package com.mp98xd.mptweaks.client;

import com.mp98xd.mptweaks.client.HUD.HUDRenderer;
import net.fabricmc.api.ClientModInitializer;

import static net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback.EVENT;

public class Mp_tweaksClient implements ClientModInitializer {

    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {

        HUDRenderer hudRenderer = new HUDRenderer();

        EVENT.register(hudRenderer);

    }
}

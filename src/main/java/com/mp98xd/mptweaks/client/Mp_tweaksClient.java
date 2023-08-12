package com.mp98xd.mptweaks.client;

import com.mp98xd.mptweaks.client.HUD.HUDRenderer;
import com.mp98xd.mptweaks.client.HUD.impl.Coordinate;
import com.mp98xd.mptweaks.client.HUD.impl.ElytraDuration;
import net.fabricmc.api.ClientModInitializer;

import static net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback.EVENT;

public class Mp_tweaksClient implements ClientModInitializer {

    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {

        HUDRenderer hudRenderer = new HUDRenderer();

        Coordinate coordinate = new Coordinate();
        hudRenderer.addHudItem(coordinate);

        ElytraDuration elytraDuration = new ElytraDuration();
        hudRenderer.addHudItem(elytraDuration);

        EVENT.register(hudRenderer);

    }
}

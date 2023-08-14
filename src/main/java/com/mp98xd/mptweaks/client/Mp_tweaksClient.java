package com.mp98xd.mptweaks.client;

import com.mp98xd.mptweaks.client.HUD.HUDRenderer;
import com.mp98xd.mptweaks.client.HUD.impl.Coordinate;
import com.mp98xd.mptweaks.client.HUD.impl.ElytraDuration;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.item.Items;

import static net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback.EVENT;

public class Mp_tweaksClient implements ClientModInitializer {

    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {

        this.initializeHUD();
        this.initializeElytraSwap();

    }

    private void initializeHUD() {
        HUDRenderer hudRenderer = new HUDRenderer();

        Coordinate coordinate = new Coordinate();
        hudRenderer.addHudItem(coordinate);

        ElytraDuration elytraDuration = new ElytraDuration();
        hudRenderer.addHudItem(elytraDuration);

        EVENT.register(hudRenderer);

        Logger.debug("Registering HUD elements");
    }

    private void initializeElytraSwap() {
        ElytraSwap elytraSwap = new ElytraSwap();

        elytraSwap.addChestPlate(Items.NETHERITE_CHESTPLATE);
        elytraSwap.addChestPlate(Items.DIAMOND_CHESTPLATE);
        elytraSwap.addChestPlate(Items.GOLDEN_CHESTPLATE);
        elytraSwap.addChestPlate(Items.IRON_CHESTPLATE);
        elytraSwap.addChestPlate(Items.CHAINMAIL_CHESTPLATE);
        elytraSwap.addChestPlate(Items.LEATHER_CHESTPLATE);

        elytraSwap.init();

    }

}

package com.mp98xd.mptweaks.client.HUD;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.HashMap;

public class HUDRenderer implements HudRenderCallback {


    private final MinecraftClient client;

    private final HashMap<String, String> hudItems;

    public HUDRenderer() {
        this.client = MinecraftClient.getInstance();
        this.hudItems = new HashMap<>();
    }

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        if (!this.client.options.hudHidden && this.client.player != null) {
            ItemStack chestPlate = this.client.player.getInventory().getArmorStack(2);

            if (chestPlate.getItem().equals(Items.ELYTRA)) {
                double elytraDurability = chestPlate.getMaxDamage() - chestPlate.getDamage();

                int elytraPercentage = (int) ( (elytraDurability / chestPlate.getMaxDamage()) * 100 );

                drawContext.drawTextWithShadow(this.client.textRenderer, String.valueOf(elytraPercentage) + "%", 0, 0, 0x6CB5FF);
            }
        }
    }


}

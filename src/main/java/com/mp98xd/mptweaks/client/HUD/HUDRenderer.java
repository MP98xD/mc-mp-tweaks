package com.mp98xd.mptweaks.client.HUD;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

import java.util.ArrayList;
import java.util.List;

public class HUDRenderer implements HudRenderCallback {

    private final MinecraftClient client;

    private final List<HUDItem> hudItems;

    private final int hudColor;

    private final int yOffset;

    public HUDRenderer() {
        this.client = MinecraftClient.getInstance();
        this.hudItems = new ArrayList<>();
        this.hudColor = 0x6CB5FF;
        this.yOffset = 10;
    }

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        if (!this.client.options.hudHidden) {

            int i = 0;

            for (HUDItem hudItem : hudItems) {
                if (hudItem.getDisabled()) {
                    continue;
                }

                drawContext.drawTextWithShadow(this.client.textRenderer, hudItem.calculate(this.client), 1,  2 + yOffset * i++, this.hudColor);
            }

        }
    }

    public void addHudItem(HUDItem hudItem) {
        this.hudItems.add(hudItem);
    }

}

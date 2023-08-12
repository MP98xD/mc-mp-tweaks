package com.mp98xd.mptweaks.client.HUD.impl;

import com.mp98xd.mptweaks.client.HUD.HUDItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ElytraDuration extends HUDItem {

    private boolean percentage = true;

    @Override
    public String calculate(MinecraftClient client) {
        if (client.player != null) {
            ItemStack chestPlate = client.player.getInventory().getArmorStack(2);

            if (chestPlate.getItem().equals(Items.ELYTRA)) {
                double elytraDurability = chestPlate.getMaxDamage() - chestPlate.getDamage();

                if (percentage) {
                    int elytraPercentage = (int) ( (elytraDurability / chestPlate.getMaxDamage()) * 100 );

                    return elytraPercentage + "%";
                }

                return String.valueOf((int) elytraDurability);
            }
        }

        return null;
    }

    public boolean isPercentage() {
        return percentage;
    }

    public void setPercentage(boolean percentage) {
        this.percentage = percentage;
    }
}

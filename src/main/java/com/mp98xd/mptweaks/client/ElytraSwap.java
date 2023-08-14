package com.mp98xd.mptweaks.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.SlotActionType;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

public class ElytraSwap {

    private static KeyBinding elytraSwapKey;

    private final int[] slots;

    private final List<Item> chestplates;

    public ElytraSwap() {
        int fullSize = PlayerInventory.MAIN_SIZE; // 36
        int hotbarSize = PlayerInventory.getHotbarSize(); // 9

        slots = new int[fullSize + 1];

        for (int i = 0; i < fullSize - hotbarSize; i++) {
            slots[i] = i + hotbarSize;
        }

        for (int i = fullSize - hotbarSize; i < fullSize; i++) {
            slots[i] = i - (fullSize - hotbarSize);
        }

        slots[fullSize] = PlayerInventory.OFF_HAND_SLOT;

        chestplates = new ArrayList<>();
    }

    public void init() {
        elytraSwapKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.mp-tweaks.swapElytra",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_GRAVE_ACCENT,
                "category.mp-tweaks.swapElytra"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (elytraSwapKey.wasPressed()) {
                this.swapChestElytra(client);
            }
        });
    }

    public void addChestPlate(Item chestplate) {
        chestplates.add(chestplate);
    }

    private void swapChestElytra(MinecraftClient client) {
        if (client.player != null && !client.player.isDead()) {
            ItemStack chestSlot = client.player.getInventory().getArmorStack(2);

            boolean elytraOn = chestSlot.getItem().equals(Items.ELYTRA);

            int slot = -1;

            if (elytraOn) {
                for (Item chestplate : chestplates) {
                    int potentialSlot = findItemSlot(client, chestplate);
                    if (potentialSlot != -1) {
                        slot = potentialSlot;
                        break;
                    }
                }
            } else {
                slot = findItemSlot(client, Items.ELYTRA);
            }

            if (slot != -1) {
                swapSlot(client, slot);
            }
        }
    }

    private int findItemSlot(MinecraftClient client, Item itemType) {
        if (client.player != null) {
            for (int slot : slots) {
                ItemStack examinedSlot = client.player.getInventory().getStack(slot);

                if (examinedSlot.getItem().equals(itemType)) {
                    return slot;
                }
            }
        }

        return -1;
    }

    private void swapSlot(MinecraftClient client,int srcSlot) {
        if (client.player == null || client.interactionManager == null) {
            Logger.error("Something went wrong. player or interactionManager object is null");
            return;
        }

        client.interactionManager.clickSlot(
                client.player.playerScreenHandler.syncId,
                6,
                srcSlot,
                SlotActionType.SWAP,
                client.player
        );
    }
}

package dev.ferriarnus.tinkersjewelry.tools.hooks;

import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.Collection;

public interface CuriosEquipHook {

    default void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {

    }

    default void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {

    }

    default boolean canUnequip(SlotContext slotContext, ItemStack stack) {
        return true;
    }

    default boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return true;
    }

    default boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }

    record AllMerger(Collection<CuriosEquipHook> modules) implements CuriosEquipHook {

        @Override
        public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
            for (CuriosEquipHook hook : modules) {
                hook.onEquip(slotContext, prevStack, stack);
            }
        }

        @Override
        public void onUnequip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
            for (CuriosEquipHook hook : modules) {
                hook.onUnequip(slotContext, prevStack, stack);
            }
        }

        @Override
        public boolean canUnequip(SlotContext slotContext, ItemStack stack) {
            for (CuriosEquipHook hook : modules) {
                if (!hook.canUnequip(slotContext, stack)) {
                    return false;
                }
            }

            return true;
        }

        @Override
        public boolean canEquip(SlotContext slotContext, ItemStack stack) {
            for (CuriosEquipHook hook : modules) {
                if (!hook.canEquip(slotContext, stack)) {
                    return false;
                }
            }

            return true;
        }

        @Override
        public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
            for (CuriosEquipHook hook : modules) {
                if (!hook.canEquipFromUse(slotContext, stack)) {
                    return false;
                }
            }

            return true;
        }
    }
}

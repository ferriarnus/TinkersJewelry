package dev.ferriarnus.tinkersjewelry.tools.hooks;

import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.Collection;

public interface CuriosTickHook {
    void curioTick(SlotContext slotContext, ItemStack stack);

    record AllMerger(Collection<CuriosTickHook> modules) implements CuriosTickHook {
        @Override
        public void curioTick(SlotContext slotContext, ItemStack stack) {
            for (CuriosTickHook hook : modules) {
                hook.curioTick(slotContext, stack);
            }
        }
    }
}

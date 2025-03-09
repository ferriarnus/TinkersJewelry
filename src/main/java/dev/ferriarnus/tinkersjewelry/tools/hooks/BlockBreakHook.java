package dev.ferriarnus.tinkersjewelry.tools.hooks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;

import java.util.Collection;

public interface BlockBreakHook {
    void breakBlock(Player player, ItemStack stackInSlot, BlockPos pos, BlockState state, ModifierEntry modifier);

    record AllMerger(Collection<BlockBreakHook> modules) implements BlockBreakHook {
        @Override
        public void breakBlock(Player player, ItemStack stackInSlot, BlockPos pos, BlockState state, ModifierEntry modifier) {
            for (BlockBreakHook module : modules) {
                module.breakBlock(player, stackInSlot, pos, state, modifier);
            }
        }
    }
}

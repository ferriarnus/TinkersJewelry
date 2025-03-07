package dev.ferriarnus.tinkersjewelry.tools.hooks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collection;

public interface BlockBreak {
    void breakBlock(Player player, ItemStack stackInSlot, BlockPos pos, BlockState state);

    record AllMerger(Collection<BlockBreak> modules) implements BlockBreak {
        @Override
        public void breakBlock(Player player, ItemStack stackInSlot, BlockPos pos, BlockState state) {
            for (BlockBreak module : modules) {
                module.breakBlock(player, stackInSlot, pos, state);
            }
        }
    }
}

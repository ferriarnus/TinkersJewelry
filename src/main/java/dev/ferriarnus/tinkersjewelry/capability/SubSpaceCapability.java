package dev.ferriarnus.tinkersjewelry.capability;

import dev.ferriarnus.tinkersjewelry.TinkersJewelry;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;

public class SubSpaceCapability implements INBTSerializable<CompoundTag> {

    public static final Capability<SubSpaceCapability> INSTANCE = CapabilityManager.get(new CapabilityToken<>() {});

    private final Player player;
    private final ItemStackHandler inventory;

    public SubSpaceCapability(Player player) {
        this.player = player;
        this.inventory = new ItemStackHandler(60) {
            @Override
            public int getSlots() {
                return super.getSlots();
            }

            @Override
            public ItemStack extractItem(int slot, int amount, boolean simulate) {
                return super.extractItem(slot, amount, simulate);
            }

            @Override
            public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Override
    public CompoundTag serializeNBT() {
        return inventory.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        inventory.deserializeNBT(compoundTag);
    }

    public ItemStackHandler getInventory() {
        return inventory;
    }

    public static class Provider implements ICapabilitySerializable<CompoundTag>, INBTSerializable<CompoundTag> {

        public static final ResourceLocation IDENTIFIER = new ResourceLocation(TinkersJewelry.MODID, "subspace");
        private final SubSpaceCapability instance;
        private final LazyOptional<SubSpaceCapability> optional;

        public Provider(Player player) {
            instance = new SubSpaceCapability(player);
            optional = LazyOptional.of(() -> instance);
        }

        @Override
        public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction direction) {
            if (capability == INSTANCE) {
                return optional.cast();
            }
            return LazyOptional.empty();
        }

        @Override
        public CompoundTag serializeNBT() {
            return instance.serializeNBT();
        }

        @Override
        public void deserializeNBT(CompoundTag compoundTag) {
            instance.deserializeNBT(compoundTag);
        }
    }
}

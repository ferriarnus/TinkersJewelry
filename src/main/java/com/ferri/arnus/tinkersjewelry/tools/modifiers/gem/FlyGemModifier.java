package com.ferri.arnus.tinkersjewelry.tools.modifiers.gem;

import com.ferri.arnus.playerattributes.CustomAttributeModifier;
import com.ferri.arnus.playerattributes.attributes.AttributeRegistry;
import com.ferri.arnus.playerattributes.operations.OperationRegistry;
import com.ferri.arnus.tinkersjewelry.items.CuriosDamageTypes;
import com.google.common.collect.Multimap;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class FlyGemModifier extends AbstractGemModifier {

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (slotContext.getWearer() instanceof ServerPlayer player) {
            if (!player.getAbilities().mayfly && player.getAttribute(AttributeRegistry.FLIGHT.get()).getValue() == 1) {
                player.onUpdateAbilities();
            }
        }
        super.curioTick(slotContext, stack);
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        if (slotContext.getWearer() instanceof ServerPlayer player) {
            player.onUpdateAbilities();
        }
        super.onUnequip(slotContext, newStack, stack);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributeModifiers = super.getAttributeModifiers(slotContext, uuid, stack);
        attributeModifiers.put(AttributeRegistry.FLIGHT.get(), new CustomAttributeModifier(uuid, "tinkersjewelry:flygem", 1, OperationRegistry.OR.get()));
        return attributeModifiers;
    }

    @Override
    public CuriosDamageTypes getDamageType() {
        return CuriosDamageTypes.NONE;
    }
}

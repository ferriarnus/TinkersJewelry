package com.ferri.arnus.tinkersjewelry.tools.modifiers.gem;

import com.ferri.arnus.playerattributes.CustomAttributeModifier;
import com.ferri.arnus.playerattributes.TranslationKeys;
import com.ferri.arnus.playerattributes.attributes.AttributeRegistry;
import com.ferri.arnus.playerattributes.operations.OperationRegistry;
import com.ferri.arnus.tinkersjewelry.items.CuriosDamageTypes;
import com.ferri.arnus.tinkersjewelry.tools.stats.JewelryToolStats;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.utils.TooltipKey;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;
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

    @Override
    public void addInformation(IToolStackView tool, int level, @Nullable Player player, List<Component> tooltip, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        float amp = tool.getMultiplier(JewelryToolStats.AMPLIFICATION);
        int effect = (int) (1 * amp);
        tooltip.add(new TranslatableComponent(TranslationKeys.FLIGHT).append(" ").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public Component getDisplayName(int level) {
        // display name without the level
        return super.getDisplayName();
    }
}

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
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.library.utils.TooltipKey;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;
import java.util.UUID;

public class SilkGemModifier extends AbstractGemModifier {

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributeModifiers = super.getAttributeModifiers(slotContext, uuid, stack);
        ToolStack toolStack = ToolStack.from(stack);
        float amp = toolStack.getMultiplier(JewelryToolStats.AMPLIFICATION);
        double effect = 1 * amp;
        attributeModifiers.put(AttributeRegistry.SILK.get(), new CustomAttributeModifier(uuid, "tinkersjewelry:silkgem", effect, OperationRegistry.MAXVALUE.get()));
        return attributeModifiers;
    }

    @Override
    public CuriosDamageTypes getDamageType() {
        return CuriosDamageTypes.BLOCK_BREAK;
    }

    @Override
    public void addInformation(IToolStackView tool, int level, @Nullable Player player, List<Component> tooltip, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        float amp = tool.getMultiplier(JewelryToolStats.AMPLIFICATION);
        double effect = level * amp;
        tooltip.add(addDiscription(TranslationKeys.SILK, effect));
    }
}

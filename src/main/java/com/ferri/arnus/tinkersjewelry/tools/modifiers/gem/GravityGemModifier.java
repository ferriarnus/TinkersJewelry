package com.ferri.arnus.tinkersjewelry.tools.modifiers.gem;

import com.ferri.arnus.tinkersjewelry.items.CuriosDamageTypes;
import com.ferri.arnus.tinkersjewelry.tools.modifiers.JewelryModifiers;
import com.ferri.arnus.tinkersjewelry.tools.stats.JewelryToolStats;
import com.google.common.collect.Multimap;
import dev.shadowsoffire.attributeslib.api.ALObjects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.common.ForgeMod;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import top.theillusivec4.curios.api.SlotContext;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class GravityGemModifier extends AbstractGemModifier{

    @Override
    public CuriosDamageTypes getDamageType() {
        return CuriosDamageTypes.HURT_PLAYER;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributeModifiers = super.getAttributeModifiers(slotContext, uuid, stack);
        ToolStack toolStack = ToolStack.from(stack);
        float amp = toolStack.getMultiplier(JewelryToolStats.AMPLIFICATION);
        int level = toolStack.getModifierLevel(JewelryModifiers.GRAVITY_GEM.getId()) - 1;
        double effect = -(0.1 + level * 0.05)* amp;
        attributeModifiers.put(ForgeMod.ENTITY_GRAVITY.get(), new AttributeModifier(uuid, "tinkersjewelry:gravitygem", effect, AttributeModifier.Operation.ADDITION));
        return attributeModifiers;
    }

    @Override
    public void addTooltip(IToolStackView iToolStackView, ModifierEntry modifierEntry, @Nullable Player player, List<Component> list, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {

    }
}

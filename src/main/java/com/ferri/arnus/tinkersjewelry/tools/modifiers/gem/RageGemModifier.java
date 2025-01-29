package com.ferri.arnus.tinkersjewelry.tools.modifiers.gem;

import java.util.List;
import java.util.UUID;

import com.ferri.arnus.tinkersjewelry.items.CuriosDamageTypes;
import com.ferri.arnus.tinkersjewelry.tools.modifiers.JewelryModifiers;
import com.ferri.arnus.tinkersjewelry.tools.stats.JewelryToolStats;
import com.google.common.collect.Multimap;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import top.theillusivec4.curios.api.SlotContext;

import javax.annotation.Nullable;

public class RageGemModifier extends AbstractGemModifier{

	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid,
			ItemStack stack) {
		Multimap<Attribute, AttributeModifier> attributeModifiers = super.getAttributeModifiers(slotContext, uuid, stack);
		ToolStack toolStack = ToolStack.from(stack);
		int level = toolStack.getModifierLevel(JewelryModifiers.RAGEGEM.getId()) - 1;
		float amp = toolStack.getMultiplier(JewelryToolStats.AMPLIFICATION);
		double effect = (1.25D + 0.25 * level) * amp;
		attributeModifiers.put(Attributes.ATTACK_SPEED, new AttributeModifier(uuid, "tinkersjewelry:ragegem", effect, AttributeModifier.Operation.MULTIPLY_BASE));
		return attributeModifiers;
	}
	
	@Override
	public CuriosDamageTypes getDamageType() {
		return CuriosDamageTypes.HURT_ENTITY;
	}

	@Override
	public void addTooltip(IToolStackView iToolStackView, ModifierEntry modifierEntry, @javax.annotation.Nullable Player player, List<Component> list, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
//		float amp = tool.getMultiplier(JewelryToolStats.AMPLIFICATION);
//		double effect = (1.25D + 0.25 * level) * amp;
//		tooltip.add(addDiscription(TranslationKeys.RAGE, effect));
	}
}

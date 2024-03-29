package com.ferri.arnus.tinkersjewelry.tools.modifiers.gem;

import java.util.List;
import java.util.UUID;

import com.ferri.arnus.playerattributes.TranslationKeys;
import com.ferri.arnus.tinkersjewelry.items.CuriosDamageTypes;
import com.ferri.arnus.tinkersjewelry.tools.stats.JewelryToolStats;
import com.google.common.collect.Multimap;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.library.utils.TooltipKey;
import top.theillusivec4.curios.api.SlotContext;

public class RageGemModifier extends AbstractGemModifier{

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		// TODO Auto-generated method stub
		super.onEquip(slotContext, prevStack, stack);
	}
	
	@Override
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		// TODO Auto-generated method stub
		super.onUnequip(slotContext, newStack, stack);
	}
	
	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid,
			ItemStack stack) {
		Multimap<Attribute, AttributeModifier> attributeModifiers = super.getAttributeModifiers(slotContext, uuid, stack);
		ToolStack toolStack = ToolStack.from(stack);
		int level = 0;
		for (ModifierEntry entry : toolStack.getModifiers().getModifiers()) {
			if (entry.getModifier().equals(this)) {
				level = entry.getLevel() -1;
			}
		}
		//
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
	public void addInformation(IToolStackView tool, int level, @Nullable Player player, List<Component> tooltip, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
		float amp = tool.getMultiplier(JewelryToolStats.AMPLIFICATION);
		double effect = (1.25D + 0.25 * level) * amp;
		tooltip.add(addDiscription(TranslationKeys.RAGE, effect));
	}

}

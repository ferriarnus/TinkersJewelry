package com.ferri.arnus.tinkersjewelry.tools.modifiers.gem;

import java.util.UUID;

import com.ferri.arnus.tinkersjewelry.items.CuriosDamageTypes;
import com.ferri.arnus.tinkersjewelry.tools.stats.JewelryToolStats;
import com.google.common.collect.Multimap;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
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
				level = entry.getLevel();
			}
		}
		//
		float amp = toolStack.getMultiplier(JewelryToolStats.AMPLIFICATION);
		double effect = level > 0 ? (1.25D + 0.25 * level) * amp : 0;
		attributeModifiers.put(Attributes.ATTACK_SPEED, new AttributeModifier(uuid, "tinkersjewelry:ragegem", effect, AttributeModifier.Operation.MULTIPLY_BASE));
		return attributeModifiers;
	}
	
	@Override
	public CuriosDamageTypes getDamageType() {
		return CuriosDamageTypes.HURT_ENTITY;
	}

}

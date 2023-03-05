package com.ferri.arnus.tinkersjewelry.tools.modifiers.gem;

import java.util.UUID;

import com.ferri.arnus.tinkersjewelry.items.CuriosDamageTypes;
import com.google.common.collect.Multimap;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
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
		attributeModifiers.put(Attributes.ATTACK_SPEED, new AttributeModifier(uuid, "tinkersjewelry:ragegem", 1.25D, AttributeModifier.Operation.MULTIPLY_BASE));
		return attributeModifiers;
	}
	
	@Override
	public CuriosDamageTypes getDamageType() {
		return CuriosDamageTypes.HURT_ENTITY;
	}

}

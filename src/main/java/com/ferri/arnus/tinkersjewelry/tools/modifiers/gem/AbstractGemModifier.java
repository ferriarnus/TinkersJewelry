package com.ferri.arnus.tinkersjewelry.tools.modifiers.gem;

import java.util.UUID;

import com.ferri.arnus.tinkersjewelry.items.CuriosDamageTypes;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import top.theillusivec4.curios.api.SlotContext;

public class AbstractGemModifier extends NoLevelsModifier{

	public void curioTick(SlotContext slotContext, ItemStack stack) {
		
	}
	
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		
	}
	
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		
	}
	
	public boolean canUnequip(SlotContext slotContext, ItemStack stack) {
		return true;
	}
	
	public boolean canEquip(SlotContext slotContext, ItemStack stack) {
		return true;
	}
	
	public boolean canRightClickEquip(ItemStack stack) {
		return true;
	}
	
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
		return HashMultimap.create();
	}

	public CuriosDamageTypes getDamageType() {
		return CuriosDamageTypes.NONE;
	}
}

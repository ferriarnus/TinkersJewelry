package com.ferri.arnus.tinkersarsenal.items;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.ferri.arnus.tinkersarsenal.tools.modifiers.AbstractGemModifier;
import com.google.common.collect.Multimap;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.definition.ToolDefinition;
import slimeknights.tconstruct.library.tools.item.ModifiableItem;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class CuriosRingItem extends ModifiableItem implements ICurioItem{

	public CuriosRingItem(Properties properties, ToolDefinition toolDefinition) {
		super(properties, toolDefinition);
	}
	
	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		ToolStack tool = ToolStack.from(stack);
		List<ModifierEntry> modifiers = tool.getModifierList();
		for (ModifierEntry entry : modifiers) {
			if (entry.getModifier() instanceof AbstractGemModifier gem) {
				gem.curioTick(slotContext, stack);
			}
		}
	}
	
	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		ToolStack tool = ToolStack.from(stack);
		List<ModifierEntry> modifiers = tool.getModifierList();
		for (ModifierEntry entry : modifiers) {
			if (entry.getModifier() instanceof AbstractGemModifier gem) {
				gem.onEquip(slotContext, prevStack, stack);
			}
		}
	}
	
	@Override
	public boolean canUnequip(SlotContext slotContext, ItemStack stack) {
		ToolStack tool = ToolStack.from(stack);
		List<ModifierEntry> modifiers = tool.getModifierList();
		for (ModifierEntry entry : modifiers) {
			if (entry.getModifier() instanceof AbstractGemModifier gem) {
				return gem.canUnequip(slotContext, stack);
			}
		}
		return ICurioItem.super.canEquip(slotContext, stack);
	}
	
	@Override
	public boolean canEquip(SlotContext slotContext, ItemStack stack) {
		ToolStack tool = ToolStack.from(stack);
		List<ModifierEntry> modifiers = tool.getModifierList();
		for (ModifierEntry entry : modifiers) {
			if (entry.getModifier() instanceof AbstractGemModifier gem) {
				return gem.canEquip(slotContext, stack);
			}
		}
		return ICurioItem.super.canEquip(slotContext, stack);
	}
	
	@Override
	public boolean canRightClickEquip(ItemStack stack) {
		ToolStack tool = ToolStack.from(stack);
		List<ModifierEntry> modifiers = tool.getModifierList();
		for (ModifierEntry entry : modifiers) {
			if (entry.getModifier() instanceof AbstractGemModifier gem) {
				return gem.canRightClickEquip(stack);
			}
		}
		return ICurioItem.super.canRightClickEquip(stack);
	}
	
	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
		ToolStack tool = ToolStack.from(stack);
		List<ModifierEntry> modifiers = tool.getModifierList();
		for (ModifierEntry entry : modifiers) {
			if (entry.getModifier() instanceof AbstractGemModifier gem) {
				return gem.getAttributeModifiers(slotContext, uuid, stack);
			}
		}
		return ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);
	}
	
	@Override
	public List<Component> getSlotsTooltip(List<Component> tooltips, ItemStack stack) {
		
		return Collections.emptyList();
	}
	
	public CuriosDamageTypes getDamageType(ItemStack stack) {
		ToolStack tool = ToolStack.from(stack);
		List<ModifierEntry> modifiers = tool.getModifierList();
		for (ModifierEntry entry : modifiers) {
			if (entry.getModifier() instanceof AbstractGemModifier gem) {
				return gem.getDamageType();
			}
		}
		return CuriosDamageTypes.NONE;
	}

}

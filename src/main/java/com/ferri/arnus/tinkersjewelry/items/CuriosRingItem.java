package com.ferri.arnus.tinkersjewelry.items;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.ferri.arnus.tinkersjewelry.tools.modifiers.gem.AbstractGemModifier;
import com.google.common.collect.Multimap;

import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.definition.ToolDefinition;
import slimeknights.tconstruct.library.tools.item.ModifiableItem;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import javax.annotation.Nullable;

public class CuriosRingItem extends ModifiableItem implements ICurioItem{

	public CuriosRingItem(Properties properties, ToolDefinition toolDefinition) {
		super(properties, toolDefinition);
	}
	
	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		ToolStack tool = ToolStack.from(stack);
		if (tool.isBroken()) {
			return;
		}
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
		if (tool.isBroken()) {
			return;
		}
		List<ModifierEntry> modifiers = tool.getModifierList();
		for (ModifierEntry entry : modifiers) {
			if (entry.getModifier() instanceof AbstractGemModifier gem) {
				gem.onEquip(slotContext, prevStack, stack);
			}
		}
	}

	@Override
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		ToolStack tool = ToolStack.from(stack);
		List<ModifierEntry> modifiers = tool.getModifierList();
		for (ModifierEntry entry : modifiers) {
			if (entry.getModifier() instanceof AbstractGemModifier gem) {
				gem.onUnequip(slotContext, newStack, stack);
			}
		}
	}

	@Override
	public boolean canUnequip(SlotContext slotContext, ItemStack stack) {
		ToolStack tool = ToolStack.from(stack);
		if (tool.isBroken()) {
			return true;
		}
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
		if (tool.isBroken()) {
			return false;
		}
		List<ModifierEntry> modifiers = tool.getModifierList();
		for (ModifierEntry entry : modifiers) {
			if (entry.getModifier() instanceof AbstractGemModifier gem) {
				return gem.canEquip(slotContext, stack);
			}
		}
		return ICurioItem.super.canEquip(slotContext, stack);
	}

	@Override
	public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
		ToolStack tool = ToolStack.from(stack);
		if (tool.isBroken()) {
			return false;
		}
		List<ModifierEntry> modifiers = tool.getModifierList();
		for (ModifierEntry entry : modifiers) {
			if (entry.getModifier() instanceof AbstractGemModifier gem) {
				return gem.canEquipFromUse(slotContext, stack);
			}
		}
		return ICurioItem.super.canEquipFromUse(slotContext, stack);
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
		ToolStack tool = ToolStack.from(stack);
		if (tool.isBroken()) {
			return ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);
		}
		List<ModifierEntry> modifiers = tool.getModifierList();
		if (tool.isBroken()) {
			return ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);
		}
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
		if (tool.isBroken()) {
			return CuriosDamageTypes.NONE;
		}
		List<ModifierEntry> modifiers = tool.getModifierList();
		for (ModifierEntry entry : modifiers) {
			if (entry.getModifier() instanceof AbstractGemModifier gem) {
				return gem.getDamageType();
			}
		}
		return CuriosDamageTypes.NONE;
	}

	public void hurtUser(ItemStack stack, DamageSource source, double damage, @Nullable LivingEntity defender, @Nullable Entity attacker) {
		ToolStack tool = ToolStack.from(stack);
		if (tool.isBroken()) {
			return;
		}
		List<ModifierEntry> modifiers = tool.getModifierList();
		for (ModifierEntry entry : modifiers) {
			if (entry.getModifier() instanceof AbstractGemModifier gem) {
				gem.hurtUser(stack, source, damage, defender, attacker);
			}
		}
	}

	public void hurtEnemy(ItemStack stack, DamageSource source, double damage, @Nullable LivingEntity defender, @Nullable LivingEntity attacker) {
		ToolStack tool = ToolStack.from(stack);
		if (tool.isBroken()) {
			return;
		}
		List<ModifierEntry> modifiers = tool.getModifierList();
		for (ModifierEntry entry : modifiers) {
			if (entry.getModifier() instanceof AbstractGemModifier gem) {
				gem.hurtEnemy(stack, source, damage, defender, attacker);
			}
		}
	}

	public void damageTool(ItemStack stack, int amount, @Nullable LivingEntity entity) {
		ToolStack tool = ToolStack.from(stack);
		if (tool.isBroken()) {
			return;
		}
		List<ModifierEntry> modifiers = tool.getModifierList();
		for (ModifierEntry entry : modifiers) {
			if (entry.getModifier() instanceof AbstractGemModifier gem) {
				gem.damageTool(stack, amount, entity);
			}
		}
	}
}

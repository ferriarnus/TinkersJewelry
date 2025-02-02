package dev.ferriarnus.tinkersjewelry.tools.modifiers.gem;

import java.util.UUID;

import dev.ferriarnus.tinkersjewelry.items.CuriosDamageTypes;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.hook.display.TooltipModifierHook;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import top.theillusivec4.curios.api.SlotContext;

import javax.annotation.Nullable;

public abstract class AbstractGemModifier extends Modifier implements TooltipModifierHook {

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
	
	public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
		return true;
	}
	
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
		return HashMultimap.create();
	}

	public abstract CuriosDamageTypes getDamageType();

	public void hurtUser(ItemStack stack, DamageSource source, double damage, @Nullable LivingEntity defender, @Nullable Entity attacker) {
		damageTool(stack, 1, defender);
	}

	public void hurtEnemy(ItemStack stack, DamageSource source, double damage, @Nullable LivingEntity defender, @Nullable LivingEntity attacker) {
		damageTool(stack, 1, attacker);
	}

	public void damageTool(ItemStack stack, int amount, @Nullable LivingEntity entity) {
		ToolDamageUtil.damage(ToolStack.from(stack), amount, entity, stack);
	}

	public MutableComponent addDiscription(String key, String effect) {
		return applyStyle(Component.literal(" +" + effect +" ").append(Component.translatable(key)));
	}

	public MutableComponent addDiscription(String key, Number effect) {
		return addDiscription(key, String.valueOf(effect));
	}
}

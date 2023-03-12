package com.ferri.arnus.tinkersjewelry;

import com.ferri.arnus.playerattributes.attributes.AttributeRegistry;
import com.ferri.arnus.playerattributes.events.EnchantmentSimulateEvent;
import com.ferri.arnus.playerattributes.events.MobEffectSimulatedEvent;
import com.ferri.arnus.tinkersjewelry.items.CuriosDamageTypes;
import com.ferri.arnus.tinkersjewelry.items.CuriosRingItem;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import top.theillusivec4.curios.api.CuriosApi;

@EventBusSubscriber(bus = Bus.FORGE)
public class DamageItemEvents {
	
	// Block break based damage (mining speed, mining level ...)
	@SubscribeEvent
	static void onBlockBreak(BlockEvent.BreakEvent event) {
		CuriosApi.getCuriosHelper().getEquippedCurios(event.getPlayer()).ifPresent(curios -> {
			for (int i=0; i < curios.getSlots(); i++) {
				ItemStack stackInSlot = curios.getStackInSlot(i);
				if (stackInSlot.getItem() instanceof CuriosRingItem item && item.getDamageType(stackInSlot) == CuriosDamageTypes.BLOCK_BREAK) {
					item.damageTool(stackInSlot, 1, event.getPlayer());
				}
			}
		});
	}
	
	// Entity damage based damage
	@SubscribeEvent
	static void onAttackEntity(LivingAttackEvent event) {
		//hurt player (or entity) (thorns, flames, teleport ...
		CuriosApi.getCuriosHelper().getEquippedCurios(event.getEntityLiving()).ifPresent(curios -> {
			for (int i=0; i < curios.getSlots(); i++) {
				ItemStack stackInSlot = curios.getStackInSlot(i);
				if (stackInSlot.getItem() instanceof CuriosRingItem item && item.getDamageType(stackInSlot) == CuriosDamageTypes.HURT_PLAYER) {
					item.damageTool(stackInSlot, event.getSource(), event.getAmount(), event.getEntityLiving());
				}
			}
		});
		
		if (event.getSource().getEntity() instanceof LivingEntity entity) { //hurt by player (or entity) (attack speed, range, ...
			CuriosApi.getCuriosHelper().getEquippedCurios(entity).ifPresent(curios -> {
				for (int i=0; i < curios.getSlots(); i++) {
					ItemStack stackInSlot = curios.getStackInSlot(i);
					if (stackInSlot.getItem() instanceof CuriosRingItem item && item.getDamageType(stackInSlot) == CuriosDamageTypes.HURT_ENTITY) {
						item.damageTool(stackInSlot, event.getSource(), event.getAmount(), entity);
					}
				}
			});
		}
	}

	/**
	 * Mobeffect based damage.
	 * This happens each tick, when the effect helper is called.
	 * Since it is called when the helper is.
	 * Since effects last some time, the helper is less of an issue.
	 * @param event
	 */
	@SubscribeEvent
	static void Mobeffect(MobEffectSimulatedEvent event) {
		if (event.getEntity().level.getGameTime() % 20 == 2) { //limit damage to once every second
			CuriosApi.getCuriosHelper().getEquippedCurios(event.getEntity()).ifPresent(curios -> {
				for (int i=0; i < curios.getSlots(); i++) {
					ItemStack stackInSlot = curios.getStackInSlot(i);
					if (stackInSlot.getItem() instanceof CuriosRingItem item && item.getDamageType(stackInSlot) == CuriosDamageTypes.MOB_EFFECT) {
						item.damageTool(stackInSlot, 1, event.getEntity(), event.getEffect());
					}
				}
			});
		}
	}

	/**
	 * Enchantment based damage, this isn't great since it hooks into the helper method which can be called for other reasons.
	 * Use other DamageTypes if possible.
	 * @param event
	 */
	@SubscribeEvent
	static void enchantment(EnchantmentSimulateEvent event) {
		CuriosApi.getCuriosHelper().getEquippedCurios(event.getEntity()).ifPresent(curios -> {
			for (int i=0; i < curios.getSlots(); i++) {
				ItemStack stackInSlot = curios.getStackInSlot(i);
				if (stackInSlot.getItem() instanceof CuriosRingItem item && item.getDamageType(stackInSlot) == CuriosDamageTypes.ENCHANTMENT) {
					item.damageTool(stackInSlot, 1, event.getEntity(), event.getEnchantment());
				}
			}
		});
	}
	
}

package dev.ferriarnus.tinkersjewelry;

import dev.ferriarnus.tinkersjewelry.items.CuriosDamageTypes;
import dev.ferriarnus.tinkersjewelry.items.CuriosRingItem;

import dev.shadowsoffire.placebo.events.GetEnchantmentLevelEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
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
		//hurt player (or entity) (thorns, flames, teleport ...)
		CuriosApi.getCuriosHelper().getEquippedCurios(event.getEntity()).ifPresent(curios -> {
			for (int i=0; i < curios.getSlots(); i++) {
				ItemStack stackInSlot = curios.getStackInSlot(i);
				if (stackInSlot.getItem() instanceof CuriosRingItem item && item.getDamageType(stackInSlot) == CuriosDamageTypes.HURT_PLAYER) {
					item.hurtUser(stackInSlot, event.getSource(), event.getAmount(), event.getEntity(), event.getSource().getEntity());
				}
			}
		});
		
		if (event.getSource().getEntity() instanceof LivingEntity entity) { //hurt by player (or entity) (attack speed, range, ...)
			CuriosApi.getCuriosHelper().getEquippedCurios(entity).ifPresent(curios -> {
				for (int i=0; i < curios.getSlots(); i++) {
					ItemStack stackInSlot = curios.getStackInSlot(i);
					if (stackInSlot.getItem() instanceof CuriosRingItem item && item.getDamageType(stackInSlot) == CuriosDamageTypes.HURT_ENTITY) {
						item.hurtEnemy(stackInSlot, event.getSource(), event.getAmount(), entity, event.getEntity());
					}
				}
			});
		}
	}

	/**
	 * Modify the enchantment level based on the curio active
	 */
	@SubscribeEvent
	static void enchantment(GetEnchantmentLevelEvent event) {

	}
	
}

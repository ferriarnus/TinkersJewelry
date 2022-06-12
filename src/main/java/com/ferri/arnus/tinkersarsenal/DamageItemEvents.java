package com.ferri.arnus.tinkersarsenal;

import com.ferri.arnus.tinkersarsenal.items.CuriosDamageTypes;
import com.ferri.arnus.tinkersarsenal.items.CuriosRingItem;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import top.theillusivec4.curios.api.CuriosApi;

@EventBusSubscriber
public class DamageItemEvents {
	
	@SubscribeEvent
	static void onBlockBreak(BlockEvent.BreakEvent event) {
		CuriosApi.getCuriosHelper().getEquippedCurios(event.getPlayer()).ifPresent(curios -> {
			
		});
	}
	
	@SubscribeEvent
	static void onAttackEntity(LivingAttackEvent event) {
		if (event.getEntityLiving() instanceof Player player) { //hurt player
			CuriosApi.getCuriosHelper().getEquippedCurios(player).ifPresent(curios -> {
				for (int i=0; i < curios.getSlots(); i++) {
					ItemStack stackInSlot = curios.getStackInSlot(i);
					if (stackInSlot.getItem() instanceof CuriosRingItem item && item.getDamageType(stackInSlot) == CuriosDamageTypes.HURT_PLAYER) {
						ToolDamageUtil.damage(ToolStack.from(stackInSlot), 1, player, stackInSlot);
					}
				}
			});
		}
		
		if (event.getEntity() instanceof Player player) { //hurt by player
			CuriosApi.getCuriosHelper().getEquippedCurios(player).ifPresent(curios -> {
				for (int i=0; i < curios.getSlots(); i++) {
					ItemStack stackInSlot = curios.getStackInSlot(i);
					if (stackInSlot.getItem() instanceof CuriosRingItem item && item.getDamageType(stackInSlot) == CuriosDamageTypes.HURT_ENTITY) {
						ToolDamageUtil.damage(ToolStack.from(stackInSlot), 1, player, stackInSlot);
					}
				}
			});
		}
	}

}

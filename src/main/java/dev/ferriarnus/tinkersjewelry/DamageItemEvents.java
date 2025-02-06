package dev.ferriarnus.tinkersjewelry;

import dev.ferriarnus.tinkersjewelry.items.CuriosDamageTypes;
import dev.ferriarnus.tinkersjewelry.items.CuriosRingItem;

import dev.shadowsoffire.placebo.events.GetEnchantmentLevelEvent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.items.IItemHandlerModifiable;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.modules.technical.ArmorLevelModule;
import slimeknights.tconstruct.library.tools.capability.EntityModifierCapability;
import slimeknights.tconstruct.library.tools.capability.TinkerDataCapability;
import slimeknights.tconstruct.library.tools.capability.TinkerDataKeys;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.tools.data.ModifierIds;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static slimeknights.tconstruct.tools.logic.ModifierEvents.SOULBOUND;

@EventBusSubscriber(bus = Bus.FORGE)
public class DamageItemEvents {

	private static final String SOULBOUND_SLOT = "curios_soulbound";

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
						item.hurtEnemy(stackInSlot, event.getSource(), event.getAmount(), event.getEntity(), entity);
					}
				}
			});
		}
	}


	@SubscribeEvent
	static void onLivingDeath(LivingDeathEvent event) {
		// this is the latest we can add slot markers to the items so we can return them to slots
		LivingEntity entity = event.getEntity();
		if (!entity.level().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY) && entity instanceof Player player && !(player instanceof FakePlayer)) {
			// Curios soul bound check
			CuriosApi.getCuriosHelper().getEquippedCurios(event.getEntity()).ifPresent(curios -> {
				for (int i=0; i < curios.getSlots(); i++) {
					ItemStack stackInSlot = curios.getStackInSlot(i);
					if (ModifierUtil.checkVolatileFlag(stackInSlot, SOULBOUND)) {
						stackInSlot.getOrCreateTag().putInt(SOULBOUND_SLOT, i);
					}
				}
			});
		}
	}

	@SubscribeEvent
	static void onPlayerDropItems(LivingDropsEvent event) {
		// only care about real players with keep inventory off
		LivingEntity entity = event.getEntity();
		var curios = CuriosApi.getCuriosHelper().getEquippedCurios(event.getEntity());
		if (!curios.isPresent()) {
			return;
		}
		if (!entity.level().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY) && entity instanceof Player player && !(entity instanceof FakePlayer)) {
			IItemHandlerModifiable iItemHandlerModifiable = curios.resolve().get();
			Collection<ItemEntity> drops = event.getDrops();
			Iterator<ItemEntity> iter = drops.iterator();
			Inventory inventory = player.getInventory();
			List<ItemEntity> takenSlot = new ArrayList<>();
			while (iter.hasNext()) {
				ItemEntity itemEntity = iter.next();
				ItemStack stack = itemEntity.getItem();
				// find items with our soulbound tag set and move them back into the inventory, will move them over later
				CompoundTag tag = stack.getTag();
				if (tag != null && tag.contains(SOULBOUND_SLOT, Tag.TAG_ANY_NUMERIC)) {
					int slot = tag.getInt(SOULBOUND_SLOT);
					// return the tool to its requested slot if possible, remove from the drops
					if (iItemHandlerModifiable.getStackInSlot(slot).isEmpty()) {
						iItemHandlerModifiable.setStackInSlot(slot, stack);
						tag.remove(SOULBOUND_SLOT);
					} else {
						// hold off on handling items that did not get the requested slot for now
						// want to make sure they don't get in the way of items that have not yet been seen
						takenSlot.add(itemEntity);
					}
					iter.remove();
					// don't clear the tag yet, we need it one last time for player clone
				}
			}
			// handle items that did not get their requested slot last, to ensure they don't take someone else's slot while being added to a default
			for (ItemEntity itemEntity : takenSlot) {
				ItemStack stack = itemEntity.getItem();
				if (!inventory.add(stack)) {
					// last resort, somehow we just cannot put the stack anywhere, so drop it on the ground
					// this should never happen, but better to be safe
					// ditch the soulbound slot tag, to prevent item stacking issues
					CompoundTag tag = stack.getTag();
					if (tag != null) {
						tag.remove(SOULBOUND_SLOT);
						if (tag.isEmpty()) {
							stack.setTag(null);
						}
					}
					drops.add(itemEntity);
				}
			}
		}
	}
}

package com.ferri.arnus.tinkersarsenal.tools.modifiers;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class BowModifier extends NoLevelsModifier{

	@Override
	public InteractionResult onToolUse(IToolStackView tool, int level, Level world, Player player, InteractionHand hand,
			EquipmentSlot slot) {
		ItemStack itemstack = new ItemStack(Items.BOW);
		boolean flag = !player.getProjectile(itemstack).isEmpty();//TODO get Arrows
		
		InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, world, player, hand, flag);
		if (ret != null) return ret.getResult();
		
		if (!player.getAbilities().instabuild && !flag) {
			return InteractionResultHolder.fail(itemstack).getResult();
		} else {
			player.startUsingItem(hand);
			return InteractionResultHolder.consume(itemstack).getResult();
		}
	}
	
	@Override
	public boolean onStoppedUsing(IToolStackView tool, int level, Level world, LivingEntity entity, int timeLeft) {
		if (entity instanceof Player) {
			Player player = (Player)entity;
			boolean flag = player.getAbilities().instabuild;
			ItemStack pStack = new ItemStack(Items.BOW);
			ItemStack itemstack = player.getProjectile(pStack);
			
			int i = getUseDuration(tool, level) - timeLeft;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(pStack, world, player, i, !itemstack.isEmpty() || flag);
			if (i < 0) return true;
			
			if (!itemstack.isEmpty() || flag) {
				if (itemstack.isEmpty()) {
					itemstack = new ItemStack(Items.ARROW);
				}
				
				float f = getPowerForTime(i);
				if (!((double)f < 0.1D)) {
					if (!world.isClientSide) {
						ArrowItem arrowitem = (ArrowItem)(itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
						AbstractArrow abstractarrow = arrowitem.createArrow(world, itemstack, player);
						abstractarrow = customArrow(abstractarrow);
						abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.0F, 1.0F);
						if (f == 1.0F) {
							abstractarrow.setCritArrow(true);
						}
						
						int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, pStack);
						if (j > 0) {
							abstractarrow.setBaseDamage(abstractarrow.getBaseDamage() + (double)j * 0.5D + 0.5D);
						}
						
						int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, pStack);
						if (k > 0) {
							abstractarrow.setKnockback(k);
						}
						
						if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, pStack) > 0) {
							abstractarrow.setSecondsOnFire(100);
						}
						
						pStack.hurtAndBreak(1, player, (p_40665_) -> {
							p_40665_.broadcastBreakEvent(player.getUsedItemHand());
						});
						if (player.getAbilities().instabuild && (itemstack.is(Items.SPECTRAL_ARROW) || itemstack.is(Items.TIPPED_ARROW))) {
							abstractarrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
						}
						
						world.addFreshEntity(abstractarrow);
					}
					
					world.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
					if (!player.getAbilities().instabuild) {
						itemstack.shrink(1);
						if (itemstack.isEmpty()) {
							player.getInventory().removeItem(itemstack);
						}
					}
					
				}
			}
			return true;
		}
		return super.onStoppedUsing(tool, level, world, entity, timeLeft);
	}
	
	@Override
	public int getUseDuration(IToolStackView tool, int level) {
		// TODO Auto-generated method stub
		return tool.getStats().getInt(ToolStats.ATTACK_SPEED)*500;
	}
	
	@Override
	public UseAnim getUseAction(IToolStackView tool, int level) {
		return UseAnim.BOW;
	}
	
	private AbstractArrow customArrow(AbstractArrow abstractarrow) {
		return abstractarrow;
	}

	public static float getPowerForTime(int pCharge) {
	      float f = (float)pCharge / 20.0F;
	      f = (f * f + f * 2.0F) / 3.0F;
	      if (f > 1.0F) {
	         f = 1.0F;
	      }

	      return f;
	   }
	
}

package com.ferri.arnus.playerattributes.attributes;

import com.ferri.arnus.playerattributes.PlayerAttributes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AttributeEvents {

    @SubscribeEvent
    static void lifesteal(LivingDamageEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity living && living.getAttributes().hasAttribute(AttributeRegistry.LIFESTEAL.get())) {
            double lifesteal = living.getAttribute(AttributeRegistry.LIFESTEAL.get()).getValue();
            living.heal((float) (lifesteal * event.getAmount()));
        }
    }

    @SubscribeEvent
    static void poison(LivingAttackEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity living && !living.hasEffect(MobEffects.POISON)) {
            double poison = living.getAttribute(AttributeRegistry.POISON.get()).getValue();
            event.getEntityLiving().addEffect(new MobEffectInstance(MobEffects.POISON, (int) (poison*60)));
        }
    }

    @SubscribeEvent
    static void fortune(BlockEvent.BreakEvent event) {
        int itemLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, event.getPlayer().getMainHandItem());
        double playerLevel = event.getPlayer().getAttribute(AttributeRegistry.FORTUNE.get()).getValue();
        if (itemLevel < playerLevel) {
            ItemStack stack = event.getPlayer().getMainHandItem().copy();
            stack.enchant(Enchantments.BLOCK_FORTUNE, (int) playerLevel);
            event.getPlayer().getMainHandItem().mineBlock(event.getPlayer().level, event.getState(), event.getPos(), event.getPlayer());
            Block.dropResources(event.getState(), event.getPlayer().level, event.getPos(), event.getWorld().getBlockEntity(event.getPos()), event.getPlayer(), stack);
            event.getWorld().removeBlock(event.getPos(), false);
            if (!event.getPlayer().level.isClientSide) {
                event.getState().getBlock().popExperience((ServerLevel) event.getPlayer().level, event.getPos(), event.getExpToDrop());
            }
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    static void silk(BlockEvent.BreakEvent event) {
        int itemLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, event.getPlayer().getMainHandItem());
        double playerLevel = event.getPlayer().getAttribute(AttributeRegistry.SILK.get()).getValue();
        if (itemLevel < playerLevel) {
            ItemStack stack = event.getPlayer().getMainHandItem().copy();
            stack.enchant(Enchantments.SILK_TOUCH, (int) playerLevel);
            event.getPlayer().getMainHandItem().mineBlock(event.getPlayer().level, event.getState(), event.getPos(), event.getPlayer());
            Block.dropResources(event.getState(), event.getPlayer().level, event.getPos(), event.getWorld().getBlockEntity(event.getPos()), event.getPlayer(), stack);
            event.getWorld().removeBlock(event.getPos(), false);
            if (!event.getPlayer().level.isClientSide) {
                event.getState().getBlock().popExperience((ServerLevel) event.getPlayer().level, event.getPos(), event.getExpToDrop());
            }
            event.setCanceled(true);
        }
    }
}

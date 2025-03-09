package dev.ferriarnus.tinkersjewelry.tools.hooks;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;

import javax.annotation.Nullable;
import java.util.Collection;

public interface HurtEnemyHook {
    void hurtEnemy(ItemStack stack, DamageSource source, double damage, @Nullable LivingEntity defender, @Nullable LivingEntity attacker, ModifierEntry modifier);

    record AllMerger(Collection<HurtEnemyHook> modules) implements HurtEnemyHook {

        @Override
        public void hurtEnemy(ItemStack stack, DamageSource source, double damage, @Nullable LivingEntity defender, @Nullable LivingEntity attacker, ModifierEntry modifier) {
            for (HurtEnemyHook hook : modules) {
                hook.hurtEnemy(stack, source, damage, defender, attacker, modifier);
            }
        }
    }
}
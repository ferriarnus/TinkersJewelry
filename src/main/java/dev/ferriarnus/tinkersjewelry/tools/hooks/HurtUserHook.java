package dev.ferriarnus.tinkersjewelry.tools.hooks;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;

import javax.annotation.Nullable;
import java.util.Collection;

public interface HurtUserHook {
    void hurtUser(ItemStack stack, DamageSource source, double damage, @Nullable LivingEntity defender, @Nullable Entity attacker, ModifierEntry modifier);

    record AllMerger(Collection<HurtUserHook> modules) implements HurtUserHook {

        @Override
        public void hurtUser(ItemStack stack, DamageSource source, double damage, @Nullable LivingEntity defender, @Nullable Entity attacker, ModifierEntry modifier) {
            for (HurtUserHook hurtUserHook : modules) {
                hurtUserHook.hurtUser(stack, source, damage, defender, attacker, modifier);
            }
        }
    }
}

package com.ferri.arnus.playerattributes.mixin;

import com.ferri.arnus.playerattributes.events.EnchantmentSimulateEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {

    @Inject(method = "getEnchantmentLevel(Lnet/minecraft/world/item/enchantment/Enchantment;Lnet/minecraft/world/entity/LivingEntity;)I", at = @At("RETURN"), cancellable = true)
    private static void playerattributes$enchantments(Enchantment pEnchantment, LivingEntity pEntity, CallbackInfoReturnable<Integer> cir) {
        if (cir.getReturnValueI() > 1) {
            int level = 0;
            EnchantmentSimulateEvent event = new EnchantmentSimulateEvent(pEnchantment, pEntity, level);
            MinecraftForge.EVENT_BUS.post(event);
            cir.setReturnValue(event.getLevel());
        }
    }
}

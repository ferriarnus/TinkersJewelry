package com.ferri.arnus.tinkersjewelry.mixin;

import com.ferri.arnus.tinkersjewelry.items.CuriosDamageTypes;
import com.ferri.arnus.tinkersjewelry.items.CuriosRingItem;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.theillusivec4.curios.api.CuriosApi;

@Mixin(MobEffectInstance.class)
public abstract class MobEffectInstanceMixin {

    @Shadow public abstract MobEffect getEffect();

    @Inject(method = "applyEffect", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/effect/MobEffect;applyEffectTick(Lnet/minecraft/world/entity/LivingEntity;I)V"))
    public void damageItem(LivingEntity pEntity, CallbackInfo ci) {
        if (pEntity.level.getGameTime() % 5 == 0) {
            CuriosApi.getCuriosHelper().getEquippedCurios(pEntity).ifPresent(curios -> {
                for (int i=0; i < curios.getSlots(); i++) {
                    ItemStack stackInSlot = curios.getStackInSlot(i);
                    if (stackInSlot.getItem() instanceof CuriosRingItem item && item.getDamageType(stackInSlot) == CuriosDamageTypes.MOB_EFFECT) {
                        item.damageTool(stackInSlot, 1, pEntity, this.getEffect());
                    }
                }
            });
        }
    }
}

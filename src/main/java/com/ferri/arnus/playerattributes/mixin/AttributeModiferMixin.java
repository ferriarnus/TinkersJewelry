package com.ferri.arnus.playerattributes.mixin;

import com.ferri.arnus.playerattributes.CustomAttributeModifier;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(AttributeModifier.class)
public class AttributeModiferMixin {

    @Inject(method = "load", at = @At("HEAD"), cancellable = true)
    private static void newLoad(CompoundTag pNbt, CallbackInfoReturnable<AttributeModifier> cir) {
        if (pNbt.contains("COperation")) {
            try {
                CustomAttributeModifier mod = CustomAttributeModifier.load(pNbt);
                cir.setReturnValue(mod);

            } catch (Exception exception) {
                cir.setReturnValue(null);
            }
        }
    }
}

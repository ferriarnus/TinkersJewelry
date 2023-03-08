package com.ferri.arnus.playerattributes.mixin;

import com.ferri.arnus.playerattributes.CustomAttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;

@Mixin(AttributeInstance.class)
public abstract class AttributeInstanceMixin {

    @Final
    @Shadow
    private Attribute attribute;

    @Shadow
    public abstract Set<AttributeModifier> getModifiers(AttributeModifier.Operation pOperation);

    @Inject(method = "calculateValue", at = @At("RETURN"), cancellable = true)
    public void playerattributes$newOperations(CallbackInfoReturnable<Double> cir) {
        double d0 = 0;
        boolean changed = false;
        for (AttributeModifier modifier: getModifiers(AttributeModifier.Operation.ADDITION)) { //Only ADDITION holds the custom ones
            if (modifier instanceof CustomAttributeModifier custom) {
                d0 = custom.getModifierOperation().handleValue(d0, custom.getAmount());
                changed = true;
            }
        }
        if (changed) {
            cir.setReturnValue(this.attribute.sanitizeValue(d0));
        }
    }
}

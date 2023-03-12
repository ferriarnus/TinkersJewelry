package com.ferri.arnus.playerattributes.mixin;

import com.electronwill.nightconfig.core.utils.ObservedMap;
import com.ferri.arnus.playerattributes.attributes.AttributeRegistry;
import com.ferri.arnus.playerattributes.events.MobEffectSimulatedEvent;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    @Shadow
    public abstract double getAttributeValue(Attribute pAttribute);

    @Shadow protected abstract boolean trapdoorUsableAsLadder(BlockPos pPos, BlockState pState);

    public LivingEntityMixin(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @ModifyArg(method = "getArmorValue", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Mth;floor(D)I"))
    public double playerattributes$piercing(double pValue) {
        return pValue * (1.0D - this.getAttributeValue(AttributeRegistry.PIERCING.get()));
    }

    @Inject(method = "hasEffect", at = @At("RETURN"), cancellable = true)
    public void playerattributes$effects(MobEffect effect, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValueZ()) {
            boolean simulate = false;
            if (effect == MobEffects.FIRE_RESISTANCE && this.getAttributeValue(AttributeRegistry.FIRERESISTANCE.get()) > 0) {
                simulate = true;
            }
            if (effect == MobEffects.WATER_BREATHING && this.getAttributeValue(AttributeRegistry.WATERBREATHING.get()) > 0) {
                simulate = true;
            }
            MobEffectSimulatedEvent event = new MobEffectSimulatedEvent((LivingEntity) (Object) this, effect, simulate);
            MinecraftForge.EVENT_BUS.post(event);
            cir.setReturnValue(event.shouldSimulate());
        }
    }
}

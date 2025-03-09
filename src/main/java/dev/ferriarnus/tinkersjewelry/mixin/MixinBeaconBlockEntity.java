package dev.ferriarnus.tinkersjewelry.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import dev.shadowsoffire.attributeslib.api.ALObjects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeaconBlockEntity.class)
public class MixinBeaconBlockEntity {

    @Inject(method = "applyEffects", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;addEffect(Lnet/minecraft/world/effect/MobEffectInstance;)Z", ordinal = 0))
    private static void applyFlight(Level level, BlockPos pos, int levels, MobEffect primary, MobEffect secondary, CallbackInfo ci, @Local Player player) {
        if (levels < 5) {
            return;
        }
        if (player.getAttributes().getValue(ALObjects.Attributes.CREATIVE_FLIGHT.get()) > 0.0) {
            player.addEffect(new MobEffectInstance(ALObjects.MobEffects.FLYING.get(), (9 + levels * 2) * 20, 0));
        }
    }
}

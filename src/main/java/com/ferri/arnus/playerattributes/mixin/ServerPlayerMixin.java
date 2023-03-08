package com.ferri.arnus.playerattributes.mixin;

import com.ferri.arnus.playerattributes.attributes.AttributeRegistry;
import com.mojang.authlib.GameProfile;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin extends Player {

    @Unique
    private boolean lastactive = false;
    public ServerPlayerMixin(Level p_36114_, BlockPos p_36115_, float p_36116_, GameProfile p_36117_) {
        super(p_36114_, p_36115_, p_36116_, p_36117_);
    }

    @Inject(method = "onUpdateAbilities", at = @At("HEAD"))
    public void fly(CallbackInfo ci) {
        boolean flight = this.getAttribute(AttributeRegistry.FLIGHT.get()).getValue() == 1;
        System.out.println("attribute: " + flight +", last: " + lastactive);
        if (lastactive != flight) {
            this.getAbilities().mayfly = flight;
            if (!flight) {
                this.getAbilities().flying = false;
            }
        }
        lastactive = flight;
    }
}

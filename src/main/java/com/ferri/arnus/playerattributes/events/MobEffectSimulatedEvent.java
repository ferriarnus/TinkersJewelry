package com.ferri.arnus.playerattributes.events;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.eventbus.api.Event;

public class MobEffectSimulatedEvent extends Event {

    private final LivingEntity entity;
    private final MobEffect effect;
    private boolean shouldSimulated;

    public MobEffectSimulatedEvent(LivingEntity entity, MobEffect effect, boolean shouldSimulated) {
        this.entity = entity;
        this.effect = effect;
        this.shouldSimulated = shouldSimulated;
    }

    public LivingEntity getEntity() {
        return entity;
    }

    public MobEffect getEffect() {
        return effect;
    }

    public boolean shouldSimulate() {
        return shouldSimulated;
    }

    public void shouldSimulate(boolean should) {
        this.shouldSimulated = should;
    }

}

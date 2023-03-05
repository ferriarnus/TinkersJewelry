package com.ferri.arnus.playerattributes.attributes;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AttributeEvents {

    @SubscribeEvent
    static void lifesteal(LivingDamageEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity living && living.getAttributes().hasAttribute(AttributeRegistry.LIFESTEAL.get())) {
            double lifesteal = living.getAttribute(AttributeRegistry.LIFESTEAL.get()).getValue();
            living.heal((float) (lifesteal * event.getAmount()));
        }
    }
}

package com.ferri.arnus.playerattributes.attributes;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = TinkersJewelry.MODID)
public class AddAttributeEvent {

    @SubscribeEvent
    static void addAttribute(EntityAttributeModificationEvent event) {
        for (EntityType<? extends LivingEntity> type: event.getTypes()) {
            event.add(type, AttributeRegistry.LIFESTEAL.get());
        }
    }
}

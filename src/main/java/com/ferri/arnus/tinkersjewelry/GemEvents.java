package com.ferri.arnus.tinkersjewelry;

import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.event.entity.player.TradeWithVillagerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GemEvents {

    @SubscribeEvent
    static void exp(PlayerXpEvent.PickupXp event) {

    }

    @SubscribeEvent
    static void trade(TradeWithVillagerEvent event) {

    }

}

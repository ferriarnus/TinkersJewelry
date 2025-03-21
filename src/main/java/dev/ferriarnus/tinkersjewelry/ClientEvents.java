package dev.ferriarnus.tinkersjewelry;

import dev.ferriarnus.tinkersjewelry.network.JewelryNetwork;
import dev.ferriarnus.tinkersjewelry.network.SubSpacePacket;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    static void playerTick(net.minecraftforge.event.TickEvent.PlayerTickEvent event) {
        if (ModClientEvents.SUBSPACE.isDown() && event.player.getAttribute(GemAttributes.SUBSPACE.get()).getValue() >= 1) {
            JewelryNetwork.getInstance().sendToServer(new SubSpacePacket());
        }
    }
}

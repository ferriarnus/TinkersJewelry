package dev.ferriarnus.tinkersjewelry;

import dev.ferriarnus.tinkersjewelry.capability.SubSpaceCapability;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerCap {

    @SubscribeEvent
    public static void attachCap(final AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            event.addCapability(SubSpaceCapability.Provider.IDENTIFIER, new SubSpaceCapability.Provider());
        }
    }

    @SubscribeEvent
    public static void copyCap(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            Player player = event.getOriginal();
            player.reviveCaps();
            player.getCapability(SubSpaceCapability.INSTANCE).ifPresent(original -> {
                event.getEntity().getCapability(SubSpaceCapability.INSTANCE).ifPresent(cap -> {
                    cap.deserializeNBT(original.serializeNBT());
                });
            });
        }
    }
}

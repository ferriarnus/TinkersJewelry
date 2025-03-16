package dev.ferriarnus.tinkersjewelry;

import dev.ferriarnus.tinkersjewelry.capability.SubSpaceCapability;
import dev.ferriarnus.tinkersjewelry.network.JewelryNetwork;
import dev.ferriarnus.tinkersjewelry.network.SubSpacePacket;
import net.minecraft.client.KeyMapping;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TickEvent {
    public static final KeyMapping SUBSPACE = new KeyMapping("key.tinkersjewelry.subspace", GLFW.GLFW_KEY_K, "key.categories.tinkersjewelry");

    @SubscribeEvent
    static void playerTick(net.minecraftforge.event.TickEvent.PlayerTickEvent event) {
        if (SUBSPACE.isDown() && event.player.getAttribute(GemAttributes.SUBSPACE.get()).getValue() >= 1) {
            JewelryNetwork.getInstance().sendToServer(new SubSpacePacket());
        }
    }

    @SubscribeEvent
    public static void attachCap(final AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player player) {
            event.addCapability(SubSpaceCapability.Provider.IDENTIFIER, new SubSpaceCapability.Provider(player));
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

package dev.ferriarnus.tinkersjewelry;

import dev.ferriarnus.tinkersjewelry.book.JewerlyBook;
import dev.ferriarnus.tinkersjewelry.client.SubSpaceScreen;
import dev.ferriarnus.tinkersjewelry.menu.JewelryMenus;
import dev.ferriarnus.tinkersjewelry.menu.SubSpaceMenu;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = TinkersJewelry.MODID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    static void construct(FMLConstructModEvent event) {
        JewerlyBook.initBook();
    }

    @SubscribeEvent
    static void setupClient(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(JewelryMenus.SUB_SPACE_MENU.get(), SubSpaceScreen::new);
        });
    }

    @SubscribeEvent
    static void registerKeyBinding(RegisterKeyMappingsEvent event) {
        event.register(TickEvent.SUBSPACE);
    }
}

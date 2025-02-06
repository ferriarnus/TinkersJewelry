package dev.ferriarnus.tinkersjewelry;

import dev.ferriarnus.tinkersjewelry.book.JewerlyBook;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = TinkersJewelry.MODID)
public class ClientEvents {

    @SubscribeEvent
    static void construct(FMLConstructModEvent event) {
        JewerlyBook.initBook();
    }
}

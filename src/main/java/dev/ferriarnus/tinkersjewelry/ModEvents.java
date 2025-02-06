package dev.ferriarnus.tinkersjewelry;

import dev.ferriarnus.tinkersjewelry.tools.modules.OverSlimeDebufModule;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;
import slimeknights.tconstruct.library.tools.definition.module.ToolModule;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = TinkersJewelry.MODID)
public class ModEvents {

    @SubscribeEvent
    static void register(RegisterEvent event) {
        if (event.getRegistryKey() == Registries.RECIPE_SERIALIZER) {
            ToolModule.LOADER.register(new ResourceLocation(TinkersJewelry.MODID, "overslime_debuf"), OverSlimeDebufModule.LOADER);
        }
    }
}

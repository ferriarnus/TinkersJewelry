package com.ferri.arnus.tinkersjewelry;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GemAttributes {

    private static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, TinkersJewelry.MODID);

    public static void register() {
        ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Attribute> FORTUNE = ATTRIBUTES.register("fortune", () -> new RangedAttribute("tinkersjewelry:fortune", 0.0d, 0.0d, 10.0d));
    public static final RegistryObject<Attribute> SILK = ATTRIBUTES.register("silk", () -> new RangedAttribute("tinkersjewelry:silk", 0.0d, 0.0d, 10.0d));
    public static final RegistryObject<Attribute> TRADE = ATTRIBUTES.register("trade", () -> new RangedAttribute("tinkersjewelry:trade", 0.0d, 0.0d, 1.0d));
}

package com.ferri.arnus.playerattributes.attributes;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AttributeRegistry {

    static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, TinkersJewelry.MODID);

    public static void register() {
        ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Attribute> LIFESTEAL = ATTRIBUTES.register("lifesteal", () -> (new RangedAttribute("lifesteal", 0, 0, 1)).setSyncable(true));
    public static final RegistryObject<Attribute> FORTUNE = ATTRIBUTES.register("fortune", () -> new RangedAttribute("fortune", 0, 0, 5));
}

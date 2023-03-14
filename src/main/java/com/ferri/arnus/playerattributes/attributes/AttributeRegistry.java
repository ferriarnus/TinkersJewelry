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
    public static final RegistryObject<Attribute> PIERCING = ATTRIBUTES.register("piercing", () -> new RangedAttribute("piercing", 0, 0, 1).setSyncable(true));
    public static final RegistryObject<Attribute> POISON = ATTRIBUTES.register("poison", () -> new Attribute("poison", 0).setSyncable(true));
    public static final RegistryObject<Attribute> FLAME = ATTRIBUTES.register("flame", () -> new Attribute("flame", 0).setSyncable(true));
    public static final RegistryObject<Attribute> FORTUNE = ATTRIBUTES.register("fortune", () -> new IntAttribute("fortune", 0, 0, 5).setSyncable(true));
    public static final RegistryObject<Attribute> SILK = ATTRIBUTES.register("silk", () -> new IntAttribute("silk", 0, 0, 5).setSyncable(true));
    public static final RegistryObject<Attribute> FIRERESISTANCE = ATTRIBUTES.register("fireresistance", () -> new IntAttribute("silk", 0, 0, 5).setSyncable(true));
    public static final RegistryObject<Attribute> WATERBREATHING = ATTRIBUTES.register("waterbreathing", () -> new IntAttribute("silk", 0, 0, 5).setSyncable(true));
    public static final RegistryObject<Attribute> FLIGHT = ATTRIBUTES.register("flight", () -> new BooleanAttribute("flight", false).setSyncable(true));

}

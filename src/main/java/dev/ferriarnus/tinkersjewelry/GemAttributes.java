package dev.ferriarnus.tinkersjewelry;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = TinkersJewelry.MODID)
public class GemAttributes {

    private static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, TinkersJewelry.MODID);

    public static void register() {
        ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Attribute> FORTUNE = ATTRIBUTES.register("fortune", () -> new RangedAttribute("tinkersjewelry:fortune", 0.0d, 0.0d, 10.0d).setSyncable(true));
    public static final RegistryObject<Attribute> SILK = ATTRIBUTES.register("silk", () -> new RangedAttribute("tinkersjewelry:silk", 0.0d, 0.0d, 10.0d).setSyncable(true));
    public static final RegistryObject<Attribute> TRADE = ATTRIBUTES.register("trade", () -> new RangedAttribute("tinkersjewelry:trade", 0.0d, 0.0d, 100.0d).setSyncable(true));

    @SubscribeEvent
    static void registerAttributes(EntityAttributeModificationEvent event) {
        event.getTypes().forEach(type -> {
            event.add(type, GemAttributes.FORTUNE.get());
            event.add(type, GemAttributes.TRADE.get());
            event.add(type, GemAttributes.SILK.get());
        });
    }
}

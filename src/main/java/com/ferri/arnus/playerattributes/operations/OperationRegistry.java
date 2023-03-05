package com.ferri.arnus.playerattributes.operations;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class OperationRegistry {

    public static final DeferredRegister<ModifierOperation> OPERATIONS = DeferredRegister.create(new ResourceLocation(TinkersJewelry.MODID, "operation_registry"), TinkersJewelry.MODID);
    public static final Supplier<IForgeRegistry<ModifierOperation>> OPERATIONS_REGISTRY = OPERATIONS.makeRegistry(ModifierOperation.class, RegistryBuilder::new);

    public static void register() {
        OPERATIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static RegistryObject<ModifierOperation> MAXVALUE = OPERATIONS.register("maxvalue", MaxLevelOperation::new);
}

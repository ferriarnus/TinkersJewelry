package com.ferri.arnus.tinkersarsenal.blockentities;

import com.ferri.arnus.tinkersarsenal.TinkersArsenal;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityRegistry {
	
	private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, TinkersArsenal.MODID);
	
	public static void registerBlockEntities() {
		BLOCK_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	//public static final RegistryObject<BlockEntityType<MillstoneBlockEntity>> MILLSTONE = register("millstone", MillstoneBlockEntity::new, BlockRegistry.MILLSTONE);
	
	private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String name, BlockEntitySupplier<T> supp, RegistryObject<? extends Block> block) {
		return BLOCK_ENTITIES.register(name, () -> BlockEntityType.Builder.of(supp, block.get()).build(null));
	}

}

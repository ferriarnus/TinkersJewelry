package com.ferri.arnus.tinkersarsenal.blocks;

import com.ferri.arnus.tinkersarsenal.TinkersArsenal;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import slimeknights.tconstruct.common.registration.BlockDeferredRegisterExtension;

public class BlockRegistry {
	
	private static final BlockDeferredRegisterExtension BLOCKS = new BlockDeferredRegisterExtension(TinkersArsenal.MODID);
	
	public static void registerBlocks() {
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

}

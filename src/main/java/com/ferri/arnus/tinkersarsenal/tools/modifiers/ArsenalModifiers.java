package com.ferri.arnus.tinkersarsenal.tools.modifiers;

import com.ferri.arnus.tinkersarsenal.TinkersArsenal;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class ArsenalModifiers {

	protected static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TinkersArsenal.MODID);
	
	public static final StaticModifier<BowModifier> bow = MODIFIERS.register("bow", BowModifier::new);
	
	public static final StaticModifier<RageGemModifier> RAGEGEM = MODIFIERS.register("ragegem", RageGemModifier::new);
	
	public static void registerModifiers() {
		MODIFIERS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}

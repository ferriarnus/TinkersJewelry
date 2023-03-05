package com.ferri.arnus.tinkersjewelry.tools.modifiers;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;

import com.ferri.arnus.tinkersjewelry.tools.modifiers.gem.LifestealGemModifier;
import com.ferri.arnus.tinkersjewelry.tools.modifiers.gem.RageGemModifier;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class JewelryModifiers {

	protected static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TinkersJewelry.MODID);
	
	public static final StaticModifier<BowModifier> bow = MODIFIERS.register("bow", BowModifier::new);
	
	public static final StaticModifier<RageGemModifier> RAGEGEM = MODIFIERS.register("ragegem", RageGemModifier::new);
	public static final StaticModifier<LifestealGemModifier> LIFESTEALGEM = MODIFIERS.register("lifestelgem", LifestealGemModifier::new);
	public static void registerModifiers() {
		MODIFIERS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}

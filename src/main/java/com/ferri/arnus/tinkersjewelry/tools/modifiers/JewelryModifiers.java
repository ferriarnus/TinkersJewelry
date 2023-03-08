package com.ferri.arnus.tinkersjewelry.tools.modifiers;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;

import com.ferri.arnus.tinkersjewelry.tools.modifiers.gem.*;
import net.minecraft.stats.Stat;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;
import slimeknights.tconstruct.tools.modifiers.upgrades.melee.PiercingModifier;

public class JewelryModifiers {

	protected static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TinkersJewelry.MODID);
	
	public static final StaticModifier<BowModifier> BOW = MODIFIERS.register("bow", BowModifier::new);
	
	public static final StaticModifier<RageGemModifier> RAGEGEM = MODIFIERS.register("ragegem", RageGemModifier::new);
	public static final StaticModifier<FlyGemModifier> FLYGEM = MODIFIERS.register("flygem", FlyGemModifier::new);
	public static final StaticModifier<LifestealGemModifier> LIFESTEALGEM = MODIFIERS.register("lifestealgem", LifestealGemModifier::new);
	public static final StaticModifier<ArmorGemModifier> ARMORGEM = MODIFIERS.register("armorgem", ArmorGemModifier::new);
	public static final StaticModifier<PiercingGemModifier> PIERCINGGEM = MODIFIERS.register("piercinggem", PiercingGemModifier::new);
	public static final StaticModifier<SpeedGemModifier> SPEEDGEM = MODIFIERS.register("speedgem", SpeedGemModifier::new);
	public static final StaticModifier<FortuneGemModifier> FORTUNEGEM = MODIFIERS.register("fortunegem", FortuneGemModifier::new);
	public static final StaticModifier<FireResistanceGemModifier> FIRERESISTANCEGEM = MODIFIERS.register("fireresistancegem", FireResistanceGemModifier::new);
	public static final StaticModifier<SilkGemModifier> SILKGEM = MODIFIERS.register("silkgem", SilkGemModifier::new);
	public static final StaticModifier<WaterBreathingGemModifier> WATERBREATHINGGEM = MODIFIERS.register("watherbreatiggem", WaterBreathingGemModifier::new);
	public static void registerModifiers() {
		MODIFIERS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}

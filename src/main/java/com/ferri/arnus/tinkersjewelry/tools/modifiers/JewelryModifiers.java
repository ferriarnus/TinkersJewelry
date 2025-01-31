package com.ferri.arnus.tinkersjewelry.tools.modifiers;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;

import com.ferri.arnus.tinkersjewelry.tools.modifiers.gem.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class JewelryModifiers {

	protected static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TinkersJewelry.MODID);

	public static final StaticModifier<RageGemModifier> RAGE_GEM = MODIFIERS.register("rage_gem", RageGemModifier::new);
	public static final StaticModifier<FlyGemModifier> FLY_GEM = MODIFIERS.register("fly_gem", FlyGemModifier::new);
	public static final StaticModifier<LifestealGemModifier> LIFESTEAL_GEM = MODIFIERS.register("lifesteal_gem", LifestealGemModifier::new);
	public static final StaticModifier<PoisonGemModifier> POISON_GEM = MODIFIERS.register("poison_gem", PoisonGemModifier::new);
	public static final StaticModifier<FlameGemModifier> FLAME_GEM = MODIFIERS.register("flame_gem", FlameGemModifier::new);
	public static final StaticModifier<ArmorGemModifier> ARMOR_GEM = MODIFIERS.register("armor_gem", ArmorGemModifier::new);
	public static final StaticModifier<PiercingGemModifier> PIERCING_GEM = MODIFIERS.register("piercing_gem", PiercingGemModifier::new);
	public static final StaticModifier<SpeedGemModifier> SPEED_GEM = MODIFIERS.register("speed_gem", SpeedGemModifier::new);
	public static final StaticModifier<FortuneGemModifier> FORTUNE_GEM = MODIFIERS.register("fortune_gem", FortuneGemModifier::new);
	public static final StaticModifier<FireResistanceGemModifier> FIRERESISTANCE_GEM = MODIFIERS.register("fireresistance_gem", FireResistanceGemModifier::new);
	public static final StaticModifier<SilkGemModifier> SILK_GEM = MODIFIERS.register("silk_gem", SilkGemModifier::new);
	public static final StaticModifier<CleanseGemModifier> CLEANSE_GEM = MODIFIERS.register("cleanse_gem", CleanseGemModifier::new);
	public static final StaticModifier<WaterBreathingGemModifier> WATERBREATHING_GEM = MODIFIERS.register("waterbreathing_gem", WaterBreathingGemModifier::new);
	public static final StaticModifier<NightVisionGemModifier> NIGHTVISION_GEM = MODIFIERS.register("nightvision_gem", NightVisionGemModifier::new);
	public static final StaticModifier<HealthGemModifier> HEALTH_GEM = MODIFIERS.register("health_gem", HealthGemModifier::new);
	public static final StaticModifier<ReachGemModifier> REACH_GEM = MODIFIERS.register("reach_gem", ReachGemModifier::new);
	public static final StaticModifier<TradeGemModifier> TRADE_GEM = MODIFIERS.register("trade_gem", TradeGemModifier::new);
	public static final StaticModifier<ExpGemModifier> EXP_GEM = MODIFIERS.register("exp_gem", ExpGemModifier::new);
	public static final StaticModifier<GravityGemModifier> GRAVITY_GEM = MODIFIERS.register("gravity_gem", GravityGemModifier::new);

	public static void registerModifiers() {
		MODIFIERS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}

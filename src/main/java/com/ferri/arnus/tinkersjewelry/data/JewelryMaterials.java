package com.ferri.arnus.tinkersjewelry.data;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;

import slimeknights.tconstruct.library.materials.definition.MaterialId;

public class JewelryMaterials {
	
	public static final MaterialId redstone = id("redstone");
	public static final MaterialId lapis = id("lapis");
	public static final MaterialId netherstar = id("netherstar");
	public static final MaterialId scute = id("scute");
	public static final MaterialId diamond = id("diamond");
	public static final MaterialId quartz = id("quartz");
	public static final MaterialId amethyst = id("amethyst");
	public static final MaterialId emerald = id("emerald");

	public static final MaterialId blood_gem = id("blood_gem");
	public static final MaterialId blazing_gem = id("blazing_gem");
	public static final MaterialId poison_gem = id("poison_gem");
	public static final MaterialId speed_gem = id("speed_gem");
	public static final MaterialId cleanse_gem = id("cleanse_gem");
	public static final MaterialId nightvision_gem = id("nightvision_gem");
	public static final MaterialId exp_gem = id("exp_gem");

	private static MaterialId id(String name) {
	    return new MaterialId(TinkersJewelry.MODID, name);
	  }

}

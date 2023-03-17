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

	public static final MaterialId bloodgem = id("bloodgem");
	public static final MaterialId blazinggem = id("blazinggem");
	public static final MaterialId poisongem = id("poisongem");
	public static final MaterialId speedgem = id("speedgem");
	public static final MaterialId cleansegem = id("cleansegem");
	
	private static MaterialId id(String name) {
	    return new MaterialId(TinkersJewelry.MODID, name);
	  }

}

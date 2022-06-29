package com.ferri.arnus.tinkersjewelry.data;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;

import slimeknights.tconstruct.library.materials.definition.MaterialId;

public class JewelryMaterials {
	
	public static final MaterialId redstone = id("redstone");
	
	private static MaterialId id(String name) {
	    return new MaterialId(TinkersJewelry.MODID, name);
	  }

}

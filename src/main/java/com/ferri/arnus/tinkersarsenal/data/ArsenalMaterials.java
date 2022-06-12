package com.ferri.arnus.tinkersarsenal.data;

import com.ferri.arnus.tinkersarsenal.TinkersArsenal;

import slimeknights.tconstruct.library.materials.definition.MaterialId;

public class ArsenalMaterials {
	
	public static final MaterialId redstone = id("redstone");
	
	private static MaterialId id(String name) {
	    return new MaterialId(TinkersArsenal.MODID, name);
	  }

}

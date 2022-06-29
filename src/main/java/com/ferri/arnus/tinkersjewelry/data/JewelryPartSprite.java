package com.ferri.arnus.tinkersjewelry.data;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;
import com.ferri.arnus.tinkersjewelry.tools.stats.GemMaterialStats;

import slimeknights.tconstruct.library.client.data.material.AbstractPartSpriteProvider;
import slimeknights.tconstruct.tools.stats.ExtraMaterialStats;

public class JewelryPartSprite extends AbstractPartSpriteProvider{

	public JewelryPartSprite() {
		super(TinkersJewelry.MODID);
	}

	@Override
	protected void addAllSpites() {
		buildTool("bow")
			.addHead("bowhandle")
			.addHandle("tool_handle")
			.addBinding("tool_binding");
		
		buildTool("ring")
		    .addPart("gem", GemMaterialStats.ID)
		    .addPart("ringpart", ExtraMaterialStats.ID); //TODO Use extra for compatibility (for now, till I get all metals separated out)
		
	}

	@Override
	public String getName() {
		return "Tinkers' Jewelry Materials";
	}

}

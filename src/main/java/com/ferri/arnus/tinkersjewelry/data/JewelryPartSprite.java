package com.ferri.arnus.tinkersjewelry.data;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;
import com.ferri.arnus.tinkersjewelry.tools.stats.BlankBandMaterialStats;
import com.ferri.arnus.tinkersjewelry.tools.stats.GemMaterialStats;

import slimeknights.tconstruct.library.client.data.material.AbstractPartSpriteProvider;

public class JewelryPartSprite extends AbstractPartSpriteProvider{

	public JewelryPartSprite() {
		super(TinkersJewelry.MODID);
	}

	@Override
	protected void addAllSpites() {
		buildTool("ring")
		    .addPart("gem", GemMaterialStats.ID)
		    .addPart("blank_band", BlankBandMaterialStats.ID);
		
	}

	@Override
	public String getName() {
		return "Tinkers' Jewelry Materials";
	}

}

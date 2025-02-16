package dev.ferriarnus.tinkersjewelry.data;

import dev.ferriarnus.tinkersjewelry.TinkersJewelry;
import dev.ferriarnus.tinkersjewelry.tools.stats.BlankBandMaterialStats;
import dev.ferriarnus.tinkersjewelry.tools.stats.GemMaterialStats;

import slimeknights.tconstruct.library.client.data.material.AbstractPartSpriteProvider;

public class JewelryPartSprite extends AbstractPartSpriteProvider {

	public JewelryPartSprite() {
		super(TinkersJewelry.MODID);
	}

	@Override
	protected void addAllSpites() {
		addPart("gem", GemMaterialStats.ID);
		addPart("plain_ring", BlankBandMaterialStats.ID);

		buildTool("ring")
		    .addPart("gem", GemMaterialStats.ID)
			.addPart("plain_ring", BlankBandMaterialStats.ID);
		
	}

	@Override
	public String getName() {
		return "Tinkers' Jewelry Materials";
	}

}

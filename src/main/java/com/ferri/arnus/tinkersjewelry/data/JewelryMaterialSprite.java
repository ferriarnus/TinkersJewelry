package com.ferri.arnus.tinkersjewelry.data;

import com.ferri.arnus.tinkersjewelry.tools.stats.GemMaterialStats;

import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToColorMapping;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

public class JewelryMaterialSprite extends AbstractMaterialSpriteProvider{

	@Override
	public String getName() {
		return "Tinkers Jewelry Materials";
	}

	@Override
	protected void addAllMaterials() {
		TinkersMaterials();
		//TODO colors for all materials, currently used from blood
		buildMaterial(JewelryMaterials.redstone)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF340605).addARGB(102, 0xFF410500).addARGB(140, 0xFF5c0700).addARGB(178, 0xFF720000).addARGB(216, 0xFFaa0f01).addARGB(255, 0xFFff0000).build());

		buildMaterial(JewelryMaterials.lapis)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF052463).addARGB(102, 0xFF12408b).addARGB(140, 0xFF1a3d8f).addARGB(178, 0xFF1c53a8).addARGB(216, 0xFF345ec3).addARGB(255, 0xFF5a82e2).build());

		buildMaterial(JewelryMaterials.netherstar)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF649090).addARGB(102, 0xFFb9c9c9).addARGB(140, 0xFFdae2e2).addARGB(178, 0xFFd2d200).addARGB(216, 0xFFe0e277).addARGB(255, 0xFFfdffa8).build());

		buildMaterial(JewelryMaterials.scute)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF206a43).addARGB(102, 0xFF297d49).addARGB(140, 0xFF388d3a).addARGB(178, 0xFF388d3a).addARGB(216, 0xFF3fa442).addARGB(255, 0xFF47bf4a).build());

		buildMaterial(JewelryMaterials.diamond)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF145e53).addARGB(102, 0xFF11727a).addARGB(140, 0xFF1c919a).addARGB(178, 0xFF20c5b5).addARGB(216, 0xFF2ce0d8).addARGB(255, 0xFFa1fbe8).build());

		buildMaterial(JewelryMaterials.quartz)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF897b73).addARGB(102, 0xFFb3a091).addARGB(140, 0xFFddd4c6).addARGB(178, 0xeFF5dfd6).addARGB(216, 0xFFeae5de).addARGB(255, 0xFFf7f5f2).build());

		buildMaterial(JewelryMaterials.amethyst)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF54398a).addARGB(102, 0xFF6f4fab).addARGB(140, 0xFF8d6acc).addARGB(178, 0xFFb38ef3).addARGB(216, 0xFFcfa0f3).addARGB(255, 0xFFfecbe6).build());

		buildMaterial(JewelryMaterials.emerald)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF005300).addARGB(102, 0xFF009529).addARGB(140, 0xFF00aa2c).addARGB(178, 0xFF17dd62).addARGB(216, 0xFF41f384).addARGB(255, 0xFFaffdcd).build());


		buildMaterial(JewelryMaterials.blood_gem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF5D0000).addARGB(102, 0xFF750000).addARGB(140, 0xFF820000).addARGB(178, 0xFFA00000).addARGB(216, 0xFFB80000).addARGB(255, 0xFFE82323).build());

		buildMaterial(JewelryMaterials.poison_gem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0x15317E).addARGB(102, 0xFF750000).addARGB(140, 0xFF820000).addARGB(178, 0xFFA00000).addARGB(216, 0xFFB80000).addARGB(255, 0xFFE82323).build());

		buildMaterial(JewelryMaterials.blazing_gem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0x15317E).addARGB(102, 0xFF750000).addARGB(140, 0xFF820000).addARGB(178, 0xFFA00000).addARGB(216, 0xFFB80000).addARGB(255, 0xFFE82323).build());

		buildMaterial(JewelryMaterials.speed_gem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0x15317E).addARGB(102, 0xFF750000).addARGB(140, 0xFF820000).addARGB(178, 0xFFA00000).addARGB(216, 0xFFB80000).addARGB(255, 0xFFE82323).build());

		buildMaterial(JewelryMaterials.cleanse_gem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0x15317E).addARGB(102, 0xFF750000).addARGB(140, 0xFF820000).addARGB(178, 0xFFA00000).addARGB(216, 0xFFB80000).addARGB(255, 0xFFE82323).build());

		buildMaterial(JewelryMaterials.nightvision_gem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0x15317E).addARGB(102, 0xFF750000).addARGB(140, 0xFF820000).addARGB(178, 0xFFA00000).addARGB(216, 0xFFB80000).addARGB(255, 0xFFE82323).build());

		buildMaterial(JewelryMaterials.exp_gem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0x15317E).addARGB(102, 0xFF750000).addARGB(140, 0xFF820000).addARGB(178, 0xFFA00000).addARGB(216, 0xFFB80000).addARGB(255, 0xFFE82323).build());

	}
	
	protected void TinkersMaterials() {
		 buildMaterial(MaterialIds.flint)
				 .statType(GemMaterialStats.ID)
				 .fallbacks("crystal", "rock", "stick")
				 .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF0E0E0E).addARGB(102, 0xFF222020).addARGB(140, 0xFF2E2D2D).addARGB(178, 0xFF3D3C3C).addARGB(216, 0xFF565656).addARGB(255, 0xFF7F7F7F).build());
	}

}

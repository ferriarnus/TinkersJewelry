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
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF5D0000).addARGB(102, 0xFF750000).addARGB(140, 0xFF820000).addARGB(178, 0xFFA00000).addARGB(216, 0xFFB80000).addARGB(255, 0xFFE82323).build());

		buildMaterial(JewelryMaterials.lapis)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0x15317E).addARGB(102, 0xFF750000).addARGB(140, 0xFF820000).addARGB(178, 0xFFA00000).addARGB(216, 0xFFB80000).addARGB(255, 0xFFE82323).build());

		buildMaterial(JewelryMaterials.netherstar)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0x15317E).addARGB(102, 0xFF750000).addARGB(140, 0xFF820000).addARGB(178, 0xFFA00000).addARGB(216, 0xFFB80000).addARGB(255, 0xFFE82323).build());

		buildMaterial(JewelryMaterials.scute)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0x15317E).addARGB(102, 0xFF750000).addARGB(140, 0xFF820000).addARGB(178, 0xFFA00000).addARGB(216, 0xFFB80000).addARGB(255, 0xFFE82323).build());

		buildMaterial(JewelryMaterials.diamond)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0x15317E).addARGB(102, 0xFF750000).addARGB(140, 0xFF820000).addARGB(178, 0xFFA00000).addARGB(216, 0xFFB80000).addARGB(255, 0xFFE82323).build());

		buildMaterial(JewelryMaterials.quartz)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0x15317E).addARGB(102, 0xFF750000).addARGB(140, 0xFF820000).addARGB(178, 0xFFA00000).addARGB(216, 0xFFB80000).addARGB(255, 0xFFE82323).build());

		buildMaterial(JewelryMaterials.amethyst)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0x15317E).addARGB(102, 0xFF750000).addARGB(140, 0xFF820000).addARGB(178, 0xFFA00000).addARGB(216, 0xFFB80000).addARGB(255, 0xFFE82323).build());


		buildMaterial(JewelryMaterials.bloodgem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF5D0000).addARGB(102, 0xFF750000).addARGB(140, 0xFF820000).addARGB(178, 0xFFA00000).addARGB(216, 0xFFB80000).addARGB(255, 0xFFE82323).build());

		buildMaterial(JewelryMaterials.poisongem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0x15317E).addARGB(102, 0xFF750000).addARGB(140, 0xFF820000).addARGB(178, 0xFFA00000).addARGB(216, 0xFFB80000).addARGB(255, 0xFFE82323).build());

		buildMaterial(JewelryMaterials.blazinggem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0x15317E).addARGB(102, 0xFF750000).addARGB(140, 0xFF820000).addARGB(178, 0xFFA00000).addARGB(216, 0xFFB80000).addARGB(255, 0xFFE82323).build());

		buildMaterial(JewelryMaterials.speedgem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0x15317E).addARGB(102, 0xFF750000).addARGB(140, 0xFF820000).addARGB(178, 0xFFA00000).addARGB(216, 0xFFB80000).addARGB(255, 0xFFE82323).build());

		buildMaterial(JewelryMaterials.cleansegem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0x15317E).addARGB(102, 0xFF750000).addARGB(140, 0xFF820000).addARGB(178, 0xFFA00000).addARGB(216, 0xFFB80000).addARGB(255, 0xFFE82323).build());

		buildMaterial(JewelryMaterials.nightvisiongem)
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

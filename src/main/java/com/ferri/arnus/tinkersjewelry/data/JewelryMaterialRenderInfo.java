package com.ferri.arnus.tinkersjewelry.data;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;

public class JewelryMaterialRenderInfo extends AbstractMaterialRenderInfoProvider{

	public JewelryMaterialRenderInfo(DataGenerator gen, AbstractMaterialSpriteProvider spriteProvider) {
		super(gen, spriteProvider);
	}

	@Override
	public String getName() {
		return "Tinkers' Jewelry Material Render Info Provider";
	}

	@Override
	protected void addMaterialRenderInfo() {
		//TODO proper for redstone color.
		buildRenderInfo(JewelryMaterials.redstone).color(0xE52323).build();
		buildRenderInfo(JewelryMaterials.bloodgem).color(0x880808).build();
		buildRenderInfo(JewelryMaterials.lapis).color(0x880808).build();
		buildRenderInfo(JewelryMaterials.netherstar).color(0x880808).build();
	}

}

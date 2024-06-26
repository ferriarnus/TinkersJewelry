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
		buildRenderInfo(JewelryMaterials.scute).color(0x880808).build();
		buildRenderInfo(JewelryMaterials.diamond).color(0x880808).build();
		buildRenderInfo(JewelryMaterials.quartz).color(0x880808).build();
		buildRenderInfo(JewelryMaterials.amethyst).color(0x880808).build();

		buildRenderInfo(JewelryMaterials.poisongem).color(0x880808).build();
		buildRenderInfo(JewelryMaterials.blazinggem).color(0x880808).build();
		buildRenderInfo(JewelryMaterials.speedgem).color(0x880808).build();
		buildRenderInfo(JewelryMaterials.cleansegem).color(0x880808).build();
		buildRenderInfo(JewelryMaterials.nightvisiongem).color(0x880808).build();

	}

}

package com.ferri.arnus.tinkersjewelry.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.materials.definition.IMaterial;

import javax.annotation.Nullable;

public class JewelryMaterialRenderInfo extends AbstractMaterialRenderInfoProvider{

	public JewelryMaterialRenderInfo(PackOutput packOutput, @Nullable AbstractMaterialSpriteProvider materialSprites, @Nullable ExistingFileHelper existingFileHelper) {
		super(packOutput, materialSprites, existingFileHelper);
	}

	@Override
	public String getName() {
		return "Tinkers' Jewelry Material Render Info Provider";
	}

	@Override
	protected void addMaterialRenderInfo() {
		// fallback
		buildRenderInfo(IMaterial.UNKNOWN_ID);

		//TODO proper for redstone color.
		buildRenderInfo(JewelryMaterials.redstone).color(0xE52323);
		buildRenderInfo(JewelryMaterials.lapis).color(0x12408b);
		buildRenderInfo(JewelryMaterials.netherstar).color(0xdae2e2);
		buildRenderInfo(JewelryMaterials.scute).color(0x297d49);
		buildRenderInfo(JewelryMaterials.diamond).color(0x1aaaa7);
		buildRenderInfo(JewelryMaterials.quartz).color(0xf7f5f2);
		buildRenderInfo(JewelryMaterials.amethyst).color(0x6f4fab);

		buildRenderInfo(JewelryMaterials.bloodgem).color(0x880808);
		buildRenderInfo(JewelryMaterials.poisongem).color(0x880808);
		buildRenderInfo(JewelryMaterials.blazinggem).color(0x880808);
		buildRenderInfo(JewelryMaterials.speedgem).color(0x880808);
		buildRenderInfo(JewelryMaterials.cleansegem).color(0x880808);
		buildRenderInfo(JewelryMaterials.nightvisiongem).color(0x880808);
	}

}

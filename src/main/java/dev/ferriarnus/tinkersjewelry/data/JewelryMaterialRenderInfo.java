package dev.ferriarnus.tinkersjewelry.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.materials.definition.IMaterial;

import javax.annotation.Nullable;

public class JewelryMaterialRenderInfo extends AbstractMaterialRenderInfoProvider {

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
		buildRenderInfo(JewelryMaterials.emerald).color(0x00aa2c);
		buildRenderInfo(JewelryMaterials.prismarine).color(0x559a8a);
		buildRenderInfo(JewelryMaterials.heart_of_the_sea).color(0x0d485f);
		buildRenderInfo(JewelryMaterials.ender_eye).color(0x316364);
		buildRenderInfo(JewelryMaterials.echo_shard).color(0x0a5060);

		buildRenderInfo(JewelryMaterials.blood_gem).color(0x851228);
		buildRenderInfo(JewelryMaterials.poison_gem).color(0x055938);
		buildRenderInfo(JewelryMaterials.blazing_gem).color(0xff8d76);
		buildRenderInfo(JewelryMaterials.speed_gem).color(0xe29f11);
		buildRenderInfo(JewelryMaterials.cleanse_gem).color(0xe0dce5);
		buildRenderInfo(JewelryMaterials.nightvision_gem).color(0x717297);
		buildRenderInfo(JewelryMaterials.exp_gem).color(0xb2e755);
		buildRenderInfo(JewelryMaterials.health_gem).color(0xff4d99);
	}

}

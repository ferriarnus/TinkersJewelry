package com.ferri.arnus.tinkersjewelry.data;

import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

public class JewelryMaterialData extends AbstractMaterialDataProvider{

	public JewelryMaterialData(PackOutput packOutput) {
		super(packOutput);
	}

	@Override
	public String getName() {
		return "Tinker's Jewelry Materials";
	}
	
	@Override
	protected void addMaterials() {
		addMaterial(JewelryMaterials.redstone, 1, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.lapis, 1, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.netherstar, 3, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.scute, 1, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.diamond, 2, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.quartz, 2, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.amethyst, 1, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.emerald, 1, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.prismarine, 1, ORDER_SPECIAL, true);

		addMaterial(JewelryMaterials.blood_gem, 2, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.poison_gem, 2, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.blazing_gem, 2, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.speed_gem, 2, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.cleanse_gem, 2, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.nightvision_gem, 2, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.exp_gem, 2, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.health_gem, 2, ORDER_SPECIAL, true);

	}

}

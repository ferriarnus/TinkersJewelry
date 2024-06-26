package com.ferri.arnus.tinkersjewelry.data;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

public class JewelryMaterialData extends AbstractMaterialDataProvider{

	public JewelryMaterialData(DataGenerator gen) {
		super(gen);
	}

	@Override
	public String getName() {
		return "Tinker's Jewelry Materials";
	}
	
	@Override
	protected void addMaterials() {
		addMaterial(JewelryMaterials.redstone, 1, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.lapis, 1, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.bloodgem, 2, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.netherstar, 3, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.scute, 2, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.diamond, 2, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.quartz, 2, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.amethyst, 1, ORDER_SPECIAL, true);

		addMaterial(JewelryMaterials.poisongem, 2, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.blazinggem, 2, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.speedgem, 2, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.cleansegem, 2, ORDER_SPECIAL, true);
		addMaterial(JewelryMaterials.nightvisiongem, 2, ORDER_SPECIAL, true);

	}

}

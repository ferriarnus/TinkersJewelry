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
		addMaterial(JewelryMaterials.bloodgem, 2, ORDER_SPECIAL, true);
		
	}

}

package com.ferri.arnus.tinkersarsenal.data;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

public class ArsenalMaterialData extends AbstractMaterialDataProvider{

	public ArsenalMaterialData(DataGenerator gen) {
		super(gen);
	}

	@Override
	public String getName() {
		return "Tinker's Arsenal Materials";
	}
	
	@Override
	protected void addMaterials() {
		addMaterial(ArsenalMaterials.redstone, 1, ORDER_SPECIAL, true);
		
	}

}

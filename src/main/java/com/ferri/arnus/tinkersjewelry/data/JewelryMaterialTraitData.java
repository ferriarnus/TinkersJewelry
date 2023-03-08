package com.ferri.arnus.tinkersjewelry.data;

import com.ferri.arnus.tinkersjewelry.tools.modifiers.JewelryModifiers;
import com.ferri.arnus.tinkersjewelry.tools.stats.GemMaterialStats;
import com.ferri.arnus.tinkersjewelry.tools.stats.RingPartMaterialStats;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

public class JewelryMaterialTraitData extends AbstractMaterialTraitDataProvider{

	public JewelryMaterialTraitData(DataGenerator gen, AbstractMaterialDataProvider materials) {
		super(gen, materials);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return "Tinker's Jewelry Material Traits";
	}

	@Override
	protected void addMaterialTraits() {
		addTraits(JewelryMaterials.redstone, GemMaterialStats.ID, JewelryModifiers.RAGEGEM);
		addTraits(JewelryMaterials.bloodgem, GemMaterialStats.ID, JewelryModifiers.LIFESTEALGEM);
		addTraits(JewelryMaterials.lapis, GemMaterialStats.ID, JewelryModifiers.FORTUNEGEM);
		addTraits(JewelryMaterials.netherstar, GemMaterialStats.ID, JewelryModifiers.FLYGEM);

		addTraits(MaterialIds.flint, GemMaterialStats.ID, new ModifierEntry(JewelryModifiers.PIERCINGGEM, 1)); //add leveled trait
		
		addTraits(MaterialIds.iron, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		
	}

}

package com.ferri.arnus.tinkersarsenal.data;

import com.ferri.arnus.tinkersarsenal.tools.modifiers.ArsenalModifiers;
import com.ferri.arnus.tinkersarsenal.tools.stats.GemMaterialStats;
import com.ferri.arnus.tinkersarsenal.tools.stats.RingPartMaterialStats;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

public class ArsenalMaterialTraitData extends AbstractMaterialTraitDataProvider{

	public ArsenalMaterialTraitData(DataGenerator gen, AbstractMaterialDataProvider materials) {
		super(gen, materials);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return "Tinker's Arsenal Material Traits";
	}

	@Override
	protected void addMaterialTraits() {
		addTraits(ArsenalMaterials.redstone, GemMaterialStats.ID, ArsenalModifiers.RAGEGEM);
		addTraits(MaterialIds.flint, GemMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		
		addTraits(MaterialIds.iron, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		
	}

}

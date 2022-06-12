package com.ferri.arnus.tinkersarsenal.data;

import com.ferri.arnus.tinkersarsenal.tools.stats.GemMaterialStats;
import com.ferri.arnus.tinkersarsenal.tools.stats.RingPartMaterialStats;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

public class ArsenalMaterialStatsData extends AbstractMaterialStatsDataProvider{

	public ArsenalMaterialStatsData(DataGenerator gen, AbstractMaterialDataProvider materials) {
		super(gen, materials);
	}

	@Override
	  public String getName() {
	    return "Tinker's Arsenal Material Stats";
	  }

	@Override
	protected void addMaterialStats() {
		
		 addMaterialStats(MaterialIds.iron, new RingPartMaterialStats(250, 1f));
		 addMaterialStats(MaterialIds.silver, new RingPartMaterialStats(300, 1.1f));
		 addMaterialStats(MaterialIds.gold, new RingPartMaterialStats(200, 1.1f));
		 
		 addMaterialStats(MaterialIds.flint, new GemMaterialStats());
		 addMaterialStats(ArsenalMaterials.redstone, new GemMaterialStats());
	}

}

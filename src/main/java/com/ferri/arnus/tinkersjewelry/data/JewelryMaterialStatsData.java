package com.ferri.arnus.tinkersjewelry.data;

import com.ferri.arnus.tinkersjewelry.tools.stats.GemMaterialStats;
import com.ferri.arnus.tinkersjewelry.tools.stats.RingPartMaterialStats;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

public class JewelryMaterialStatsData extends AbstractMaterialStatsDataProvider{

	public JewelryMaterialStatsData(DataGenerator gen, AbstractMaterialDataProvider materials) {
		super(gen, materials);
	}

	@Override
	  public String getName() {
	    return "Tinker's Jewelry Material Stats";
	  }

	@Override
	protected void addMaterialStats() {
		
		 addMaterialStats(MaterialIds.iron, new RingPartMaterialStats(250, 1f));
		 addMaterialStats(MaterialIds.silver, new RingPartMaterialStats(300, 1.1f));
		 addMaterialStats(MaterialIds.gold, new RingPartMaterialStats(200, 1.1f));
		 
		 addMaterialStats(MaterialIds.flint, new GemMaterialStats());
		 addMaterialStats(JewelryMaterials.redstone, new GemMaterialStats());
	}

}

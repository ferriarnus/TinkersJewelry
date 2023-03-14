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

		addMaterialStats(MaterialIds.copper, new RingPartMaterialStats(130, 0.9f));

		addMaterialStats(MaterialIds.iron, new RingPartMaterialStats(250, 1.2f));
		addMaterialStats(MaterialIds.gold, new RingPartMaterialStats(200, 1.4f));

		addMaterialStats(MaterialIds.osmium, new RingPartMaterialStats(500, 1f));
		addMaterialStats(MaterialIds.tungsten, new RingPartMaterialStats(350, 1.3f));
		addMaterialStats(MaterialIds.platinum, new RingPartMaterialStats(400, 1.4f));
		addMaterialStats(MaterialIds.silver, new RingPartMaterialStats(300, 1.1f));
		addMaterialStats(MaterialIds.lead, new RingPartMaterialStats(200, 1f));

		addMaterialStats(MaterialIds.slimesteel, new RingPartMaterialStats(1040, 1.2f));
		addMaterialStats(MaterialIds.amethystBronze, new RingPartMaterialStats(720, 1.3f));
		addMaterialStats(MaterialIds.nahuatl, new RingPartMaterialStats(350, 0.8f));
		addMaterialStats(MaterialIds.pigIron, new RingPartMaterialStats(580, 1.2f));
		addMaterialStats(MaterialIds.roseGold, new RingPartMaterialStats(175, 1.6f));

		addMaterialStats(MaterialIds.steel, new RingPartMaterialStats(775, 1.2f));
		addMaterialStats(MaterialIds.bronze, new RingPartMaterialStats(760, 1.3f));
		addMaterialStats(MaterialIds.constantan, new RingPartMaterialStats(675, 1.4f));
		addMaterialStats(MaterialIds.invar, new RingPartMaterialStats(630, 1.1f));
		addMaterialStats(MaterialIds.necronium, new RingPartMaterialStats(357, 0.9f));
		addMaterialStats(MaterialIds.electrum, new RingPartMaterialStats(225, 1.5f));
		addMaterialStats(MaterialIds.platedSlimewood, new RingPartMaterialStats(595, 0.9f));

		addMaterialStats(MaterialIds.manyullyn, new RingPartMaterialStats(1250, 1.2f));


		addMaterialStats(JewelryMaterials.redstone, GemMaterialStats.DEFAULT);
		addMaterialStats(JewelryMaterials.bloodgem, GemMaterialStats.DEFAULT);
		addMaterialStats(JewelryMaterials.lapis, GemMaterialStats.DEFAULT);
		addMaterialStats(JewelryMaterials.netherstar, GemMaterialStats.DEFAULT);
		addMaterialStats(JewelryMaterials.scute, GemMaterialStats.DEFAULT);
		addMaterialStats(JewelryMaterials.poisongem, GemMaterialStats.DEFAULT);
		addMaterialStats(JewelryMaterials.blazinggem, GemMaterialStats.DEFAULT);

		addMaterialStats(MaterialIds.rock, GemMaterialStats.DEFAULT);
		addMaterialStats(MaterialIds.ichor, GemMaterialStats.DEFAULT);
		addMaterialStats(MaterialIds.flint, GemMaterialStats.DEFAULT);
	}

}

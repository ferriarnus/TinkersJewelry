package com.ferri.arnus.tinkersjewelry.data;

import com.ferri.arnus.tinkersjewelry.tools.stats.GemMaterialStats;
import com.ferri.arnus.tinkersjewelry.tools.stats.BlankBandMaterialStats;

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

		addMaterialStats(MaterialIds.copper, new BlankBandMaterialStats(130, 0.9f));

		addMaterialStats(MaterialIds.iron, new BlankBandMaterialStats(250, 1.2f));
		addMaterialStats(MaterialIds.gold, new BlankBandMaterialStats(200, 1.4f));

		addMaterialStats(MaterialIds.osmium, new BlankBandMaterialStats(500, 1f));
		addMaterialStats(MaterialIds.tungsten, new BlankBandMaterialStats(350, 1.3f));
		addMaterialStats(MaterialIds.platinum, new BlankBandMaterialStats(400, 1.4f));
		addMaterialStats(MaterialIds.silver, new BlankBandMaterialStats(300, 1.1f));
		addMaterialStats(MaterialIds.lead, new BlankBandMaterialStats(200, 1f));

		addMaterialStats(MaterialIds.slimesteel, new BlankBandMaterialStats(1040, 1.2f));
		addMaterialStats(MaterialIds.amethystBronze, new BlankBandMaterialStats(720, 1.3f));
		addMaterialStats(MaterialIds.nahuatl, new BlankBandMaterialStats(350, 0.8f));
		addMaterialStats(MaterialIds.pigIron, new BlankBandMaterialStats(580, 1.2f));
		addMaterialStats(MaterialIds.roseGold, new BlankBandMaterialStats(175, 1.6f));

		addMaterialStats(MaterialIds.steel, new BlankBandMaterialStats(775, 1.2f));
		addMaterialStats(MaterialIds.bronze, new BlankBandMaterialStats(760, 1.3f));
		addMaterialStats(MaterialIds.constantan, new BlankBandMaterialStats(675, 1.4f));
		addMaterialStats(MaterialIds.invar, new BlankBandMaterialStats(630, 1.1f));
		addMaterialStats(MaterialIds.necronium, new BlankBandMaterialStats(357, 0.9f));
		addMaterialStats(MaterialIds.electrum, new BlankBandMaterialStats(225, 1.5f));
		addMaterialStats(MaterialIds.platedSlimewood, new BlankBandMaterialStats(595, 0.9f));

		addMaterialStats(MaterialIds.manyullyn, new BlankBandMaterialStats(1250, 1.2f));


		addMaterialStats(JewelryMaterials.redstone, GemMaterialStats.DEFAULT);
		addMaterialStats(JewelryMaterials.bloodgem, GemMaterialStats.DEFAULT);
		addMaterialStats(JewelryMaterials.lapis, GemMaterialStats.DEFAULT);
		addMaterialStats(JewelryMaterials.netherstar, GemMaterialStats.DEFAULT);
		addMaterialStats(JewelryMaterials.scute, GemMaterialStats.DEFAULT);
		addMaterialStats(JewelryMaterials.diamond, GemMaterialStats.DEFAULT);
		addMaterialStats(JewelryMaterials.quartz, GemMaterialStats.DEFAULT);
		addMaterialStats(JewelryMaterials.amethyst, GemMaterialStats.DEFAULT);

		addMaterialStats(JewelryMaterials.poisongem, GemMaterialStats.DEFAULT);
		addMaterialStats(JewelryMaterials.blazinggem, GemMaterialStats.DEFAULT);
		addMaterialStats(JewelryMaterials.speedgem, GemMaterialStats.DEFAULT);
		addMaterialStats(JewelryMaterials.cleansegem, GemMaterialStats.DEFAULT);
		addMaterialStats(JewelryMaterials.nightvisiongem, GemMaterialStats.DEFAULT);

		addMaterialStats(MaterialIds.rock, GemMaterialStats.DEFAULT);
		addMaterialStats(MaterialIds.ichor, GemMaterialStats.DEFAULT);
		addMaterialStats(MaterialIds.flint, GemMaterialStats.DEFAULT);
	}

}

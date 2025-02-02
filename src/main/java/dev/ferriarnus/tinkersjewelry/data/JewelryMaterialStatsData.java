package dev.ferriarnus.tinkersjewelry.data;

import dev.ferriarnus.tinkersjewelry.tools.stats.GemMaterialStats;
import dev.ferriarnus.tinkersjewelry.tools.stats.BlankBandMaterialStats;

import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

public class JewelryMaterialStatsData extends AbstractMaterialStatsDataProvider{

	public JewelryMaterialStatsData(PackOutput packOutput, AbstractMaterialDataProvider materials) {
		super(packOutput, materials);
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
		addMaterialStats(MaterialIds.cobalt, new BlankBandMaterialStats(850, 0.7f));

		addMaterialStats(MaterialIds.steel, new BlankBandMaterialStats(775, 1.2f));
		addMaterialStats(MaterialIds.bronze, new BlankBandMaterialStats(760, 1.3f));
		addMaterialStats(MaterialIds.constantan, new BlankBandMaterialStats(675, 1.4f));
		addMaterialStats(MaterialIds.invar, new BlankBandMaterialStats(630, 1.1f));
		addMaterialStats(MaterialIds.necronium, new BlankBandMaterialStats(357, 0.9f));
		addMaterialStats(MaterialIds.electrum, new BlankBandMaterialStats(225, 1.5f));
		addMaterialStats(MaterialIds.platedSlimewood, new BlankBandMaterialStats(595, 0.9f));

		addMaterialStats(MaterialIds.queensSlime, new BlankBandMaterialStats(1650, 1f));
		addMaterialStats(MaterialIds.hepatizon, new BlankBandMaterialStats(975, 1.3f));
		addMaterialStats(MaterialIds.manyullyn, new BlankBandMaterialStats(1250, 1.2f));


		addMaterialStats(JewelryMaterials.redstone, GemMaterialStats.INSTANCE);
		addMaterialStats(JewelryMaterials.blood_gem, GemMaterialStats.INSTANCE);
		addMaterialStats(JewelryMaterials.lapis, GemMaterialStats.INSTANCE);
		addMaterialStats(JewelryMaterials.netherstar, GemMaterialStats.INSTANCE);
		addMaterialStats(JewelryMaterials.scute, GemMaterialStats.INSTANCE);
		addMaterialStats(JewelryMaterials.diamond, GemMaterialStats.INSTANCE);
		addMaterialStats(JewelryMaterials.quartz, GemMaterialStats.INSTANCE);
		addMaterialStats(JewelryMaterials.amethyst, GemMaterialStats.INSTANCE);
		addMaterialStats(JewelryMaterials.emerald, GemMaterialStats.INSTANCE);
		addMaterialStats(JewelryMaterials.prismarine, GemMaterialStats.INSTANCE);
		addMaterialStats(JewelryMaterials.heart_of_the_sea, GemMaterialStats.INSTANCE);

		addMaterialStats(JewelryMaterials.poison_gem, GemMaterialStats.INSTANCE);
		addMaterialStats(JewelryMaterials.blazing_gem, GemMaterialStats.INSTANCE);
		addMaterialStats(JewelryMaterials.speed_gem, GemMaterialStats.INSTANCE);
		addMaterialStats(JewelryMaterials.cleanse_gem, GemMaterialStats.INSTANCE);
		addMaterialStats(JewelryMaterials.nightvision_gem, GemMaterialStats.INSTANCE);
		addMaterialStats(JewelryMaterials.exp_gem, GemMaterialStats.INSTANCE);
		addMaterialStats(JewelryMaterials.health_gem, GemMaterialStats.INSTANCE);

		addMaterialStats(MaterialIds.rock, GemMaterialStats.INSTANCE);
		addMaterialStats(MaterialIds.ichor, GemMaterialStats.INSTANCE);
		addMaterialStats(MaterialIds.flint, GemMaterialStats.INSTANCE);
		addMaterialStats(MaterialIds.obsidian, GemMaterialStats.INSTANCE);
		addMaterialStats(MaterialIds.enderslime, GemMaterialStats.INSTANCE);
		addMaterialStats(MaterialIds.skyslime, GemMaterialStats.INSTANCE);
		addMaterialStats(MaterialIds.earthslime, GemMaterialStats.INSTANCE);
		addMaterialStats(MaterialIds.necroticBone, GemMaterialStats.INSTANCE);
		addMaterialStats(MaterialIds.bone, GemMaterialStats.INSTANCE);
		addMaterialStats(MaterialIds.blazingBone, GemMaterialStats.INSTANCE);
		addMaterialStats(MaterialIds.venombone, GemMaterialStats.INSTANCE);
		addMaterialStats(MaterialIds.scorchedStone, GemMaterialStats.INSTANCE);
		addMaterialStats(MaterialIds.searedStone, GemMaterialStats.INSTANCE);

	}

}

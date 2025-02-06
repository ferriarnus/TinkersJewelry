package dev.ferriarnus.tinkersjewelry.data;

import dev.ferriarnus.tinkersjewelry.tools.stats.GemMaterialStats;

import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToColorMapping;

public class JewelryMaterialSprite extends AbstractMaterialSpriteProvider {

	@Override
	public String getName() {
		return "Tinkers Jewelry Materials";
	}

	@Override
	protected void addAllMaterials() {
		buildMaterial(JewelryMaterials.redstone)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF340605).addARGB(102, 0xFF410500).addARGB(140, 0xFF5c0700).addARGB(178, 0xFF720000).addARGB(216, 0xFFaa0f01).addARGB(255, 0xFFff0000).build());

		buildMaterial(JewelryMaterials.lapis)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF052463).addARGB(102, 0xFF12408b).addARGB(140, 0xFF1a3d8f).addARGB(178, 0xFF1c53a8).addARGB(216, 0xFF345ec3).addARGB(255, 0xFF5a82e2).build());

		buildMaterial(JewelryMaterials.netherstar)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF649090).addARGB(102, 0xFFb9c9c9).addARGB(140, 0xFFdae2e2).addARGB(178, 0xFFd2d200).addARGB(216, 0xFFe0e277).addARGB(255, 0xFFfdffa8).build());

		buildMaterial(JewelryMaterials.scute)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF206a43).addARGB(102, 0xFF297d49).addARGB(140, 0xFF388d3a).addARGB(178, 0xFF388d3a).addARGB(216, 0xFF3fa442).addARGB(255, 0xFF47bf4a).build());

		buildMaterial(JewelryMaterials.diamond)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF145e53).addARGB(102, 0xFF11727a).addARGB(140, 0xFF1c919a).addARGB(178, 0xFF20c5b5).addARGB(216, 0xFF2ce0d8).addARGB(255, 0xFFa1fbe8).build());

		buildMaterial(JewelryMaterials.quartz)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF897b73).addARGB(102, 0xFFb3a091).addARGB(140, 0xFFddd4c6).addARGB(178, 0xeFF5dfd6).addARGB(216, 0xFFeae5de).addARGB(255, 0xFFf7f5f2).build());

		buildMaterial(JewelryMaterials.amethyst)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF54398a).addARGB(102, 0xFF6f4fab).addARGB(140, 0xFF8d6acc).addARGB(178, 0xFFb38ef3).addARGB(216, 0xFFcfa0f3).addARGB(255, 0xFFfecbe6).build());

		buildMaterial(JewelryMaterials.emerald)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF005300).addARGB(102, 0xFF009529).addARGB(140, 0xFF00aa2c).addARGB(178, 0xFF17dd62).addARGB(216, 0xFF41f384).addARGB(255, 0xFFaffdcd).build());

		buildMaterial(JewelryMaterials.prismarine)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF2e6053).addARGB(102, 0xFF33695b).addARGB(140, 0xFF559a8a).addARGB(178, 0xFF539882).addARGB(216, 0xFF91c2ac).addARGB(255, 0xFFa4d1c2).build());

		buildMaterial(JewelryMaterials.heart_of_the_sea)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF0b3a4d).addARGB(102, 0xFF0d485f).addARGB(140, 0xFF0f5875).addARGB(178, 0xFF1d6d8d).addARGB(216, 0xFF2180a1).addARGB(255, 0xFF1f96b1).build());

		buildMaterial(JewelryMaterials.ender_eye)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF032620).addARGB(102, 0xFF0C3730).addARGB(140, 0xFF0B4D42).addARGB(178, 0xFF659b7d).addARGB(216, 0xFF71ac49).addARGB(255, 0xFF1e4835).build());

		buildMaterial(JewelryMaterials.echo_shard)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF111b21).addARGB(102, 0xFF052a32).addARGB(140, 0xFF034150).addARGB(178, 0xFF0a5060).addARGB(216, 0xFF0a5060).addARGB(255, 0xFF29dfeb).build());


		buildMaterial(JewelryMaterials.blood_gem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF620819).addARGB(102, 0xFFa71c1c).addARGB(140, 0xFF4f9f9d).addARGB(178, 0xFF7bc0bf).addARGB(216, 0xFFd42b2b).addARGB(255, 0xFFe84848).build());

		buildMaterial(JewelryMaterials.poison_gem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF012718).addARGB(102, 0xFF159854).addARGB(140, 0xFF21ac63).addARGB(178, 0xFF07593f).addARGB(216, 0xFF0c7b4b).addARGB(255, 0xFF64d49c).build());

		buildMaterial(JewelryMaterials.blazing_gem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFFa61b38).addARGB(102, 0xFFd02e40).addARGB(140, 0xFFff5754).addARGB(178, 0xFFff8453).addARGB(216, 0xFFff9966).addARGB(255, 0xFFffc86a).build());

		buildMaterial(JewelryMaterials.speed_gem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF713f00).addARGB(102, 0xFF9d5103).addARGB(140, 0xFFce7404).addARGB(178, 0xFFf2b733).addARGB(216, 0xFFfac132).addARGB(255, 0xFFf6bf49).build());

		buildMaterial(JewelryMaterials.cleanse_gem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF443d50).addARGB(102, 0xFF797088).addARGB(140, 0xFFb1a9be).addARGB(178, 0xFFc8c2d2).addARGB(216, 0xFFece8f2).addARGB(255, 0xFFfdfcff).build());

		buildMaterial(JewelryMaterials.nightvision_gem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF161724).addARGB(102, 0xFF40405a).addARGB(140, 0xFF545473).addARGB(178, 0xFF717297).addARGB(216, 0xFF8c8cb2).addARGB(255, 0xFFb3b3d6).build());

		buildMaterial(JewelryMaterials.exp_gem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF1c3000).addARGB(102, 0xFF426703).addARGB(140, 0xFF2f8b27).addARGB(178, 0xFF98cb3f).addARGB(216, 0xFFb2e755).addARGB(255, 0xFFeffeda).build());

		buildMaterial(JewelryMaterials.health_gem)
				.statType(GemMaterialStats.ID)
				.colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF801175).addARGB(102, 0xFFbe2165).addARGB(140, 0xFFf03a84).addARGB(178, 0xFFff4d99).addARGB(216, 0xFFff8dae).addARGB(255, 0xffffb8cd).build());

	}
}

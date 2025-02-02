package dev.ferriarnus.tinkersjewelry.data;

import dev.ferriarnus.tinkersjewelry.TinkersJewelry;
import dev.ferriarnus.tinkersjewelry.items.ItemRegistry;
import dev.ferriarnus.tinkersjewelry.tools.JewelryDefinitions;

import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.tinkering.AbstractToolDefinitionDataProvider;
import slimeknights.tconstruct.library.materials.RandomMaterial;
import slimeknights.tconstruct.library.tools.definition.module.material.DefaultMaterialsModule;
import slimeknights.tconstruct.library.tools.definition.module.material.PartStatsModule;

public class JewelryToolDefinitionData extends AbstractToolDefinitionDataProvider{

	public JewelryToolDefinitionData(PackOutput packOutput) {
		super(packOutput, TinkersJewelry.MODID);
	}
	
	@Override
	protected void addToolDefinitions() {
		RandomMaterial tier1Material = RandomMaterial.random().tier(1).build();
		DefaultMaterialsModule defaultTwoParts = DefaultMaterialsModule.builder().material(tier1Material, tier1Material).build();

		define(JewelryDefinitions.RING)
			.module(PartStatsModule.parts()
				.part(ItemRegistry.BLANK_BAND)
				.part(ItemRegistry.GEM).build())
			.module(defaultTwoParts)
			.build();
		
	}
	
	@Override
	public String getName() {
		return "Tinkers' Jewelry Tool Definition Data Generator";
	}

}

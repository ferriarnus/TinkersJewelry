package com.ferri.arnus.tinkersjewelry.data;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;
import com.ferri.arnus.tinkersjewelry.items.ItemRegistry;
import com.ferri.arnus.tinkersjewelry.tools.JewelryDefinitions;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.tinkering.AbstractToolDefinitionDataProvider;
import slimeknights.tconstruct.library.materials.RandomMaterial;
import slimeknights.tconstruct.library.tools.definition.module.build.SetStatsModule;
import slimeknights.tconstruct.library.tools.definition.module.material.DefaultMaterialsModule;
import slimeknights.tconstruct.library.tools.definition.module.material.PartStatsModule;
import slimeknights.tconstruct.library.tools.nbt.StatsNBT;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

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
			.smallToolStartingSlots()
			.build();
		
	}
	
	@Override
	public String getName() {
		return "Tinkers' Jewelry Tool Definition Data Generator";
	}

}

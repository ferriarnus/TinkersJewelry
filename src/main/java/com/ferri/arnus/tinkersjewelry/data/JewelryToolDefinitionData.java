package com.ferri.arnus.tinkersjewelry.data;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;
import com.ferri.arnus.tinkersjewelry.items.ItemRegistry;
import com.ferri.arnus.tinkersjewelry.tools.JewelryDefinitions;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.tinkering.AbstractToolDefinitionDataProvider;

public class JewelryToolDefinitionData extends AbstractToolDefinitionDataProvider{

	public JewelryToolDefinitionData(DataGenerator generator) {
		super(generator, TinkersJewelry.MODID);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void addToolDefinitions() {
		
		define(JewelryDefinitions.RING)
		// parts
			.part(ItemRegistry.BLANK_BAND)
			.part(ItemRegistry.GEM)
		// stats
			.smallToolStartingSlots()
			.build();
		
	}
	
	@Override
	public String getName() {
		return "Tinkers' Jewelry Tool Definition Data Generator";
	}


}

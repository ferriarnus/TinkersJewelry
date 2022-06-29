package com.ferri.arnus.tinkersjewelry.data;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;
import com.ferri.arnus.tinkersjewelry.items.ItemRegistry;
import com.ferri.arnus.tinkersjewelry.tools.JewelryDefinitions;
import com.ferri.arnus.tinkersjewelry.tools.modifiers.JewelryModifiers;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.tinkering.AbstractToolDefinitionDataProvider;
import slimeknights.tconstruct.library.tools.definition.aoe.BoxAOEIterator;
import slimeknights.tconstruct.library.tools.definition.aoe.IBoxExpansion;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.tools.TinkerToolParts;

public class JewelryToolDefinitionData extends AbstractToolDefinitionDataProvider{

	public JewelryToolDefinitionData(DataGenerator generator) {
		super(generator, TinkersJewelry.MODID);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void addToolDefinitions() {
		define(JewelryDefinitions.BOW)
		// parts
			.part(ItemRegistry.bowhandle)
			.part(TinkerToolParts.toolHandle)
			.part(TinkerToolParts.toolBinding)
		// stats
			.stat(ToolStats.ATTACK_DAMAGE, 0.5f) // gains +0.5 damage from tool piercing, hence being lower than vanilla
			.stat(ToolStats.ATTACK_SPEED, 1.2f)
			.smallToolStartingSlots()
		// traits
			.trait(JewelryModifiers.bow)
		// harvest
			.aoe(BoxAOEIterator.builder(0, 0, 0).addDepth(2).addHeight(1).direction(IBoxExpansion.PITCH)
			.build());
		
		define(JewelryDefinitions.RING)
		// parts
			.part(ItemRegistry.ringpart)
			.part(ItemRegistry.gem)
		// stats
			.smallToolStartingSlots()
			.build();
		
	}
	
	@Override
	public String getName() {
		return "Tinkers' Jewelry Tool Definition Data Generator";
	}


}

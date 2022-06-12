package com.ferri.arnus.tinkersarsenal.data;

import com.ferri.arnus.tinkersarsenal.TinkersArsenal;
import com.ferri.arnus.tinkersarsenal.items.ItemRegistry;
import com.ferri.arnus.tinkersarsenal.tools.ArsenalDefinitions;
import com.ferri.arnus.tinkersarsenal.tools.modifiers.ArsenalModifiers;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.tinkering.AbstractToolDefinitionDataProvider;
import slimeknights.tconstruct.library.tools.definition.aoe.BoxAOEIterator;
import slimeknights.tconstruct.library.tools.definition.aoe.IBoxExpansion;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.tools.TinkerToolParts;

public class ArsenalToolDefinitionData extends AbstractToolDefinitionDataProvider{

	public ArsenalToolDefinitionData(DataGenerator generator) {
		super(generator, TinkersArsenal.MODID);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void addToolDefinitions() {
		define(ArsenalDefinitions.BOW)
		// parts
			.part(ItemRegistry.bowhandle)
			.part(TinkerToolParts.toolHandle)
			.part(TinkerToolParts.toolBinding)
		// stats
			.stat(ToolStats.ATTACK_DAMAGE, 0.5f) // gains +0.5 damage from tool piercing, hence being lower than vanilla
			.stat(ToolStats.ATTACK_SPEED, 1.2f)
			.smallToolStartingSlots()
		// traits
			.trait(ArsenalModifiers.bow)
		// harvest
			.aoe(BoxAOEIterator.builder(0, 0, 0).addDepth(2).addHeight(1).direction(IBoxExpansion.PITCH)
			.build());
		
		define(ArsenalDefinitions.RING)
		// parts
			.part(ItemRegistry.ringpart)
			.part(ItemRegistry.gem)
		// stats
			.smallToolStartingSlots()
			.build();
		
	}
	
	@Override
	public String getName() {
		return "Tinkers' Arsenal Tool Definition Data Generator";
	}


}

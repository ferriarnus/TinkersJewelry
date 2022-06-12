package com.ferri.arnus.tinkersarsenal.data;

import com.ferri.arnus.tinkersarsenal.items.ItemRegistry;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.tinkering.AbstractStationSlotLayoutProvider;
import slimeknights.tconstruct.tools.TinkerToolParts;

public class ArsenalStationSlotLayout extends AbstractStationSlotLayoutProvider{

	public ArsenalStationSlotLayout(DataGenerator generator) {
		super(generator);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void addLayouts() {
		defineModifiable(ItemRegistry.bow)
		.sortIndex(SORT_HARVEST)
		.addInputItem(ItemRegistry.bowhandle,    53, 22)
		.addInputItem(TinkerToolParts.toolHandle,  15, 60)
		.addInputItem(TinkerToolParts.toolBinding, 33, 42)
		.build();
		
		defineModifiable(ItemRegistry.ring)
		.sortIndex(SORT_HARVEST)
		.addInputItem(ItemRegistry.ringpart,    53, 22)
		.addInputItem(ItemRegistry.gem,  15, 60)
		.build();
		
	}

	@Override
	public String getName() {
		return "Tinkers' Arsenal Tinker Station Slot Layouts";
	}

}

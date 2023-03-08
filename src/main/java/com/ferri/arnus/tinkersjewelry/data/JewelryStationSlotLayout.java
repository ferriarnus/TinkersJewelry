package com.ferri.arnus.tinkersjewelry.data;

import com.ferri.arnus.tinkersjewelry.items.ItemRegistry;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.tinkering.AbstractStationSlotLayoutProvider;
import slimeknights.tconstruct.tools.TinkerToolParts;

public class JewelryStationSlotLayout extends AbstractStationSlotLayoutProvider{

	public JewelryStationSlotLayout(DataGenerator generator) {
		super(generator);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void addLayouts() {
		defineModifiable(ItemRegistry.BOW)
		.sortIndex(SORT_HARVEST)
		.addInputItem(ItemRegistry.BOWHANDLE,    53, 22)
		.addInputItem(TinkerToolParts.toolHandle,  15, 60)
		.addInputItem(TinkerToolParts.toolBinding, 33, 42)
		.build();
		
		defineModifiable(ItemRegistry.RING)
		.sortIndex(SORT_HARVEST)
		.addInputItem(ItemRegistry.RINGPART,    53, 22)
		.addInputItem(ItemRegistry.GEM,  15, 60)
		.build();
		
	}

	@Override
	public String getName() {
		return "Tinkers' Jewelry Tinker Station Slot Layouts";
	}

}

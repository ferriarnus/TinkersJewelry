package com.ferri.arnus.tinkersjewelry.data;

import com.ferri.arnus.tinkersjewelry.items.ItemRegistry;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.tinkering.AbstractStationSlotLayoutProvider;

public class JewelryStationSlotLayout extends AbstractStationSlotLayoutProvider{

	public JewelryStationSlotLayout(DataGenerator generator) {
		super(generator);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void addLayouts() {
		
		defineModifiable(ItemRegistry.RING)
		.sortIndex(SORT_HARVEST)
		.addInputItem(ItemRegistry.BLANK_BAND, 15   , 60)
		.addInputItem(ItemRegistry.GEM,  53, 22)
		.build();
		
	}

	@Override
	public String getName() {
		return "Tinkers' Jewelry Tinker Station Slot Layouts";
	}

}

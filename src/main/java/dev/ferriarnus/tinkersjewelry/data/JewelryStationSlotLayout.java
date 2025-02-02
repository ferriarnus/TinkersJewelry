package dev.ferriarnus.tinkersjewelry.data;

import dev.ferriarnus.tinkersjewelry.items.ItemRegistry;

import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.tinkering.AbstractStationSlotLayoutProvider;

public class JewelryStationSlotLayout extends AbstractStationSlotLayoutProvider{

	public JewelryStationSlotLayout(PackOutput packOutput) {
		super(packOutput);
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

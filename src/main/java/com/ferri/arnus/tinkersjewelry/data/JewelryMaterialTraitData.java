package com.ferri.arnus.tinkersjewelry.data;

import com.ferri.arnus.tinkersjewelry.tools.modifiers.JewelryModifiers;
import com.ferri.arnus.tinkersjewelry.tools.stats.GemMaterialStats;
import com.ferri.arnus.tinkersjewelry.tools.stats.BlankBandMaterialStats;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

public class JewelryMaterialTraitData extends AbstractMaterialTraitDataProvider{

	public JewelryMaterialTraitData(DataGenerator gen, AbstractMaterialDataProvider materials) {
		super(gen, materials);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return "Tinker's Jewelry Material Traits";
	}

	@Override
	protected void addMaterialTraits() {
		addTraits(JewelryMaterials.redstone, GemMaterialStats.ID, JewelryModifiers.RAGEGEM);
		addTraits(JewelryMaterials.bloodgem, GemMaterialStats.ID, JewelryModifiers.LIFESTEALGEM);
		addTraits(JewelryMaterials.lapis, GemMaterialStats.ID, JewelryModifiers.FORTUNEGEM);
		addTraits(JewelryMaterials.netherstar, GemMaterialStats.ID, JewelryModifiers.FLYGEM);
		addTraits(JewelryMaterials.scute, GemMaterialStats.ID, JewelryModifiers.WATERBREATHINGGEM);
		addTraits(JewelryMaterials.diamond, GemMaterialStats.ID, new ModifierEntry(JewelryModifiers.ARMORGEM, 3));
		addTraits(JewelryMaterials.quartz, GemMaterialStats.ID, new ModifierEntry(JewelryModifiers.PIERCINGGEM, 3));
		addTraits(JewelryMaterials.amethyst, GemMaterialStats.ID, JewelryModifiers.SILKGEM);

		addTraits(JewelryMaterials.poisongem, GemMaterialStats.ID, JewelryModifiers.POISONGEM);
		addTraits(JewelryMaterials.blazinggem, GemMaterialStats.ID, JewelryModifiers.FLAMEGEM);
		addTraits(JewelryMaterials.speedgem, GemMaterialStats.ID, JewelryModifiers.SPEEDGEM);
		addTraits(JewelryMaterials.cleansegem, GemMaterialStats.ID, JewelryModifiers.CLEANSEGEM);
		addTraits(JewelryMaterials.nightvisiongem, GemMaterialStats.ID, JewelryModifiers.NIGHTVISIONGEM);

		addTraits(MaterialIds.rock, GemMaterialStats.ID, new ModifierEntry(JewelryModifiers.ARMORGEM, 1));
		addTraits(MaterialIds.ichor, GemMaterialStats.ID, JewelryModifiers.FIRERESISTANCEGEM);
		addTraits(MaterialIds.flint, GemMaterialStats.ID, new ModifierEntry(JewelryModifiers.PIERCINGGEM, 1));
		addTraits(MaterialIds.obsidian, GemMaterialStats.ID, new ModifierEntry(JewelryModifiers.PIERCINGGEM, 2));


		addTraits(MaterialIds.copper, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait

		addTraits(MaterialIds.iron, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.gold, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait

		addTraits(MaterialIds.osmium, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.tungsten, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.platinum, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.silver, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.lead, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait

		addTraits(MaterialIds.slimesteel, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.amethystBronze, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.nahuatl, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.pigIron, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.roseGold, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait

		addTraits(MaterialIds.steel, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.bronze, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.constantan, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.invar, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.necronium, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.electrum, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.platedSlimewood, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait

		addTraits(MaterialIds.manyullyn, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait

	}

}

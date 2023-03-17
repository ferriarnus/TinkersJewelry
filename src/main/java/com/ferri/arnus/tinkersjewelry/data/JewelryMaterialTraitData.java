package com.ferri.arnus.tinkersjewelry.data;

import com.ferri.arnus.tinkersjewelry.tools.modifiers.JewelryModifiers;
import com.ferri.arnus.tinkersjewelry.tools.stats.GemMaterialStats;
import com.ferri.arnus.tinkersjewelry.tools.stats.RingPartMaterialStats;

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

		addTraits(MaterialIds.rock, GemMaterialStats.ID, new ModifierEntry(JewelryModifiers.ARMORGEM, 1));
		addTraits(MaterialIds.ichor, GemMaterialStats.ID, JewelryModifiers.FIRERESISTANCEGEM);
		addTraits(MaterialIds.flint, GemMaterialStats.ID, new ModifierEntry(JewelryModifiers.PIERCINGGEM, 1));
		addTraits(MaterialIds.obsidian, GemMaterialStats.ID, new ModifierEntry(JewelryModifiers.PIERCINGGEM, 2));


		addTraits(MaterialIds.copper, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait

		addTraits(MaterialIds.iron, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.gold, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait

		addTraits(MaterialIds.osmium, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.tungsten, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.platinum, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.silver, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.lead, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait

		addTraits(MaterialIds.slimesteel, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.amethystBronze, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.nahuatl, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.pigIron, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.roseGold, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait

		addTraits(MaterialIds.steel, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.bronze, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.constantan, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.invar, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.necronium, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.electrum, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.platedSlimewood, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait

		addTraits(MaterialIds.manyullyn, RingPartMaterialStats.ID, new ModifierEntry[] {} ); //remove trait

	}

}

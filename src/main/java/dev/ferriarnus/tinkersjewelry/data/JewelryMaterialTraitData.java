package dev.ferriarnus.tinkersjewelry.data;

import dev.ferriarnus.tinkersjewelry.tools.modifiers.JewelryModifiers;
import dev.ferriarnus.tinkersjewelry.tools.stats.GemMaterialStats;
import dev.ferriarnus.tinkersjewelry.tools.stats.BlankBandMaterialStats;

import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.data.ModifierIds;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

public class JewelryMaterialTraitData extends AbstractMaterialTraitDataProvider {

	public JewelryMaterialTraitData(PackOutput packOutput, AbstractMaterialDataProvider materials) {
		super(packOutput, materials);
	}

	@Override
	public String getName() {
		return "Tinker's Jewelry Material Traits";
	}

	@Override
	protected void addMaterialTraits() {
		addTraits(JewelryMaterials.redstone, GemMaterialStats.ID, JewelryModifiers.RAGE_GEM);
		addTraits(JewelryMaterials.blood_gem, GemMaterialStats.ID, JewelryModifiers.LIFESTEAL_GEM);
		addTraits(JewelryMaterials.lapis, GemMaterialStats.ID, JewelryModifiers.FORTUNE_GEM);
		addTraits(JewelryMaterials.netherstar, GemMaterialStats.ID, JewelryModifiers.FLY_GEM);
		addTraits(JewelryMaterials.scute, GemMaterialStats.ID, JewelryModifiers.WATERBREATHING_GEM);
		addTraits(JewelryMaterials.diamond, GemMaterialStats.ID, new ModifierEntry(JewelryModifiers.ARMOR_GEM, 3));
		addTraits(JewelryMaterials.quartz, GemMaterialStats.ID, new ModifierEntry(JewelryModifiers.PIERCING_GEM, 3));
		addTraits(JewelryMaterials.amethyst, GemMaterialStats.ID, JewelryModifiers.SILK_GEM);
		addTraits(JewelryMaterials.emerald, GemMaterialStats.ID, JewelryModifiers.TRADE_GEM);
		addTraits(JewelryMaterials.prismarine, GemMaterialStats.ID, JewelryModifiers.SWIM_GEM);
		addTraits(JewelryMaterials.heart_of_the_sea, GemMaterialStats.ID, JewelryModifiers.CONDUIT_GEM);
		addTraits(JewelryMaterials.ender_eye, GemMaterialStats.ID, JewelryModifiers.ENDERCLEARANCE_GEM);
		addTraits(JewelryMaterials.echo_shard, GemMaterialStats.ID, JewelryModifiers.DARKNESS_GEM.getId(), ModifierIds.soulbound);
		addTraits(JewelryMaterials.glowstone, GemMaterialStats.ID, JewelryModifiers.GLOWING_GEM);
		addTraits(JewelryMaterials.prismarine_crystal, GemMaterialStats.ID, JewelryModifiers.GLOWING_GEM);


		addTraits(JewelryMaterials.poison_gem, GemMaterialStats.ID, JewelryModifiers.POISON_GEM, JewelryModifiers.ANTI_HEAL_GEM);
		addTraits(JewelryMaterials.blazing_gem, GemMaterialStats.ID, new ModifierEntry(JewelryModifiers.FLAME_GEM, 2),
				new ModifierEntry(JewelryModifiers.FIRERESISTANCE_GEM, 1));
		addTraits(JewelryMaterials.speed_gem, GemMaterialStats.ID, JewelryModifiers.SPEED_GEM);
		addTraits(JewelryMaterials.cleanse_gem, GemMaterialStats.ID, JewelryModifiers.CLEANSE_GEM);
		addTraits(JewelryMaterials.nightvision_gem, GemMaterialStats.ID, JewelryModifiers.NIGHTVISION_GEM);
		addTraits(JewelryMaterials.exp_gem, GemMaterialStats.ID, JewelryModifiers.EXP_GEM);
		addTraits(JewelryMaterials.health_gem, GemMaterialStats.ID, JewelryModifiers.HEALTH_GEM);

		addTraits(MaterialIds.rock, GemMaterialStats.ID, JewelryModifiers.ARMOR_GEM);
		addTraits(MaterialIds.ichor, GemMaterialStats.ID, TinkerModifiers.overslime, JewelryModifiers.FIRERESISTANCE_GEM);
		addTraits(MaterialIds.flint, GemMaterialStats.ID, JewelryModifiers.PIERCING_GEM);
		addTraits(MaterialIds.obsidian, GemMaterialStats.ID, new ModifierEntry(JewelryModifiers.ARMOR_GEM, 1),
				new ModifierEntry(JewelryModifiers.PIERCING_GEM, 2));
		addTraits(MaterialIds.enderslime, GemMaterialStats.ID, TinkerModifiers.overslime, JewelryModifiers.REACH_GEM);
		addTraits(MaterialIds.skyslime, GemMaterialStats.ID, TinkerModifiers.overslime, JewelryModifiers.GRAVITY_GEM);
		addTraits(MaterialIds.earthslime, GemMaterialStats.ID, TinkerModifiers.overslime, JewelryModifiers.RESISTANCE_GEM);
		addTraits(MaterialIds.necroticBone, GemMaterialStats.ID, JewelryModifiers.CURRENT_HEALTH_DAMAGE_GEM);
		addTraits(MaterialIds.bone, GemMaterialStats.ID, JewelryModifiers.DRAW_SPEED_GEM);
		addTraits(MaterialIds.blazingBone, GemMaterialStats.ID, new ModifierEntry(JewelryModifiers.FLAME_GEM, 3));
		addTraits(MaterialIds.venombone, GemMaterialStats.ID, JewelryModifiers.POISON_GEM);
		addTraits(MaterialIds.scorchedStone, GemMaterialStats.ID, JewelryModifiers.FLAME_GEM);
		addTraits(MaterialIds.searedStone, GemMaterialStats.ID, JewelryModifiers.MINING_SPEED_GEM);
		addTraits(MaterialIds.enderPearl, GemMaterialStats.ID, JewelryModifiers.ENDERFERENCE_GEM);
		addTraits(MaterialIds.whitestone, GemMaterialStats.ID, new ModifierEntry(JewelryModifiers.RESISTANCE_GEM, 2));

		addTraits(MaterialIds.copper, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait

		addTraits(MaterialIds.iron, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.gold, BlankBandMaterialStats.ID, new ModifierEntry(JewelryModifiers.PRECIOUS, 1));

		addTraits(MaterialIds.osmium, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.tungsten, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.platinum, BlankBandMaterialStats.ID, new ModifierEntry(JewelryModifiers.PRECIOUS, 1));
		addTraits(MaterialIds.silver, BlankBandMaterialStats.ID, new ModifierEntry(JewelryModifiers.PRECIOUS, 1));
		addTraits(MaterialIds.lead, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait

		addTraits(MaterialIds.slimesteel, BlankBandMaterialStats.ID, new ModifierEntry(ModifierIds.overcast, 1), new ModifierEntry(TinkerModifiers.overslime, 1));
		addTraits(MaterialIds.amethystBronze, BlankBandMaterialStats.ID, new ModifierEntry(JewelryModifiers.PRECIOUS, 1)); //remove trait
		addTraits(MaterialIds.nahuatl, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.pigIron, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.roseGold, BlankBandMaterialStats.ID, new ModifierEntry(JewelryModifiers.PRECIOUS, 1));
		addTraits(MaterialIds.cobalt, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait

		addTraits(MaterialIds.steel, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.bronze, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.constantan, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.invar, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.necronium, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.electrum, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.platedSlimewood, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait

		addTraits(MaterialIds.manyullyn, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.hepatizon, BlankBandMaterialStats.ID, new ModifierEntry[] {} ); //remove trait
		addTraits(MaterialIds.queensSlime, BlankBandMaterialStats.ID, new ModifierEntry(TinkerModifiers.overlord, 1), new ModifierEntry(TinkerModifiers.overslime, 1), new ModifierEntry(JewelryModifiers.PRECIOUS, 1));

	}

}

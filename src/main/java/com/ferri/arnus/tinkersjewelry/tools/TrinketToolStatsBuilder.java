package com.ferri.arnus.tinkersjewelry.tools;

import java.util.List;

import com.ferri.arnus.tinkersjewelry.tools.stats.JewelryToolStats;
import com.ferri.arnus.tinkersjewelry.tools.stats.GemMaterialStats;
import com.ferri.arnus.tinkersjewelry.tools.stats.BlankBandMaterialStats;

import slimeknights.tconstruct.library.tools.definition.PartRequirement;
import slimeknights.tconstruct.library.tools.definition.ToolDefinition;
import slimeknights.tconstruct.library.tools.definition.ToolDefinitionData;
import slimeknights.tconstruct.library.tools.nbt.MaterialNBT;
import slimeknights.tconstruct.library.tools.nbt.StatsNBT.Builder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.library.tools.stat.ToolStatsBuilder;

public class TrinketToolStatsBuilder extends ToolStatsBuilder{
	private final List<GemMaterialStats> gems;
	private final List<BlankBandMaterialStats> part;
	
	public TrinketToolStatsBuilder(ToolDefinitionData toolData, List<GemMaterialStats> gems, List<BlankBandMaterialStats> part) {
		super(toolData);
		this.gems = gems;
		this.part = part;
	}
	
	public static ToolStatsBuilder from(ToolDefinition toolDefinition, MaterialNBT materials) {
		ToolDefinitionData data = toolDefinition.getData();
		List<PartRequirement> requiredComponents = data.getParts();
		if (materials.size() != requiredComponents.size()) {
			return ToolStatsBuilder.noParts(toolDefinition);
		}
		return new TrinketToolStatsBuilder(data, listOfCompatibleWith(GemMaterialStats.ID, materials, requiredComponents),listOfCompatibleWith(BlankBandMaterialStats.ID, materials, requiredComponents));
	}
	
	@Override
	protected void setStats(Builder builder) {
		builder.set(ToolStats.DURABILITY, buildDurability());
		builder.set(JewelryToolStats.AMPLIFICATION, buildAmplification());
	}

	private float buildDurability() {
		double averageHeadDurability = getAverageValue(part, BlankBandMaterialStats::getDurability) + getStatOrDefault(ToolStats.DURABILITY, 0f);
		return Math.max(1, (int)(averageHeadDurability));
	}

	private float buildAmplification() {
		double averageAmplification = getAverageValue(part, BlankBandMaterialStats::getAmplification) + getStatOrDefault(JewelryToolStats.AMPLIFICATION, 0f);
		return (float) Math.max(0.1d , averageAmplification);
	}

}

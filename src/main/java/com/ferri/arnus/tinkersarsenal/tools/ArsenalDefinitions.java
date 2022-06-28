package com.ferri.arnus.tinkersarsenal.tools;

import java.util.List;

import com.ferri.arnus.tinkersarsenal.items.ItemRegistry;
import com.ferri.arnus.tinkersarsenal.tools.stats.GemMaterialStats;
import com.ferri.arnus.tinkersarsenal.tools.stats.RingPartMaterialStats;

import slimeknights.tconstruct.library.materials.stats.MaterialStatsId;
import slimeknights.tconstruct.library.tools.definition.IToolStatProvider;
import slimeknights.tconstruct.library.tools.definition.PartRequirement;
import slimeknights.tconstruct.library.tools.definition.ToolDefinition;
import slimeknights.tconstruct.library.tools.definition.ToolDefinitionData;
import slimeknights.tconstruct.library.tools.nbt.MaterialNBT;
import slimeknights.tconstruct.library.tools.nbt.StatsNBT;

public class ArsenalDefinitions {
	
	public static final IToolStatProvider JEWELRY = new IToolStatProvider() {
		@Override
		public StatsNBT buildStats(ToolDefinition definition, MaterialNBT materials) {
			return TrinketToolStatsBuilder.from(definition, materials).buildStats();
		}
		
		@Override
		public boolean isMultipart() {
			return true;
		}
		
		@Override
		public void validate(ToolDefinitionData data) {
			List<PartRequirement> requirements = data.getParts();
			if (requirements.isEmpty()) {
				throw new IllegalStateException("Must have at least one tool part for a jewelry tool");
			}
			boolean foundHead = false;
			for (PartRequirement req : requirements) {
				MaterialStatsId statType = req.getStatType();
				if (statType.equals(RingPartMaterialStats.ID)) {
					foundHead = true;
				} else if (!statType.equals(GemMaterialStats.ID)) {
					throw new IllegalStateException("Invalid jewelry tool part type, only support ring and gem part types");
				}
			}
			if (!foundHead) {
				throw new IllegalStateException("jewelry tool must use at least one head part");
			}
		}
	};

	public static final ToolDefinition BOW = ToolDefinition.builder(ItemRegistry.bow).meleeHarvest().build();
	
	public static final ToolDefinition RING = ToolDefinition.builder(ItemRegistry.ring).setStatsProvider(JEWELRY).build();
	
	
}

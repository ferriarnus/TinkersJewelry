package com.ferri.arnus.tinkersjewelry.tools.stats;

import java.util.Collections;
import java.util.List;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import slimeknights.mantle.data.loadable.record.SingletonLoader;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.materials.stats.IMaterialStats;
import slimeknights.tconstruct.library.materials.stats.MaterialStatType;
import slimeknights.tconstruct.library.materials.stats.MaterialStatsId;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;

public record GemMaterialStats() implements IMaterialStats {
	
	public static final MaterialStatsId ID = new MaterialStatsId(new ResourceLocation(TinkersJewelry.MODID, "gem"));
	public static final GemMaterialStats INSTANCE = new GemMaterialStats();
	public static final MaterialStatType<GemMaterialStats> TYPE = new MaterialStatType<>(ID, INSTANCE, new SingletonLoader<>(INSTANCE));
	private static final Component NO_STATS = IMaterialStats.makeTooltip(TConstruct.getResource("extra.no_stats"));
	private static final List<Component> LOCALIZED = Collections.singletonList(NO_STATS);
	private static final List<Component> DESCRIPTION = Collections.singletonList(Component.empty());


	@Override
	public MaterialStatType<?> getType() {
		return TYPE;
	}

	@Override
	public MaterialStatsId getIdentifier() {
		return ID;
	}

	@Override
	public List<Component> getLocalizedInfo() {
		return LOCALIZED;
	}

	@Override
	public List<Component> getLocalizedDescriptions() {
		return DESCRIPTION;
	}

	@Override
	public void apply(ModifierStatsBuilder modifierStatsBuilder, float v) {

	}

}

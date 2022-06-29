package com.ferri.arnus.tinkersjewelry.tools.stats;

import java.util.Collections;
import java.util.List;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.materials.stats.BaseMaterialStats;
import slimeknights.tconstruct.library.materials.stats.MaterialStatsId;

public class GemMaterialStats extends BaseMaterialStats{
	
	public static final MaterialStatsId ID = new MaterialStatsId(new ResourceLocation(TinkersJewelry.MODID, "gem"));
	public static final GemMaterialStats DEFAULT = new GemMaterialStats();
	private static final Component NO_STATS = makeTooltip(TConstruct.getResource("extra.no_stats"));
	private static final List<Component> LOCALIZED = Collections.singletonList(NO_STATS);
	private static final List<Component> DESCRIPTION = Collections.singletonList(TextComponent.EMPTY);
	
	public GemMaterialStats() {
		
	}
	
	public GemMaterialStats(FriendlyByteBuf buffer) {
		
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
	public void encode(FriendlyByteBuf buffer) {
		
	}

}

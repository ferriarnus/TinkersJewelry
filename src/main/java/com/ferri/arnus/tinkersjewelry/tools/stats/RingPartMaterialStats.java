package com.ferri.arnus.tinkersjewelry.tools.stats;

import java.util.List;
import java.util.Objects;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.materials.stats.BaseMaterialStats;
import slimeknights.tconstruct.library.materials.stats.IRepairableMaterialStats;
import slimeknights.tconstruct.library.materials.stats.MaterialStatsId;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class RingPartMaterialStats extends BaseMaterialStats implements IRepairableMaterialStats{
	
	public static final MaterialStatsId ID = new MaterialStatsId(new ResourceLocation(TinkersJewelry.MODID, "ringpart"));
	private static final List<Component> DESCRIPTION = ImmutableList.of(ToolStats.DURABILITY.getDescription(), JewelryToolStats.AMPLIFICATION.getDescription());
	public static final RingPartMaterialStats DEFAULT = new RingPartMaterialStats(100, 1f);

	private float amplification;
	private int durability;
	
	public RingPartMaterialStats(int durability, float amplification) {
		this.amplification = amplification;
		this.durability = durability;
	}
	
	public RingPartMaterialStats(FriendlyByteBuf buffer) {
		this.durability = buffer.readInt();
		this.amplification = buffer.readFloat();
	}
	
	@Override
	public MaterialStatsId getIdentifier() {
		return ID;
	}

	@Override
	public List<Component> getLocalizedInfo() {
		List<Component> info = Lists.newArrayList();
		info.add(ToolStats.DURABILITY.formatValue(this.durability));
		info.add(JewelryToolStats.AMPLIFICATION.formatValue(amplification));
		return info;
	}

	@Override
	public List<Component> getLocalizedDescriptions() {
		return DESCRIPTION;
	}

	@Override
	public void encode(FriendlyByteBuf buffer) {
		buffer.writeInt(durability);
		buffer.writeFloat(amplification);
	}

	@Override
	public int getDurability() {
		return this.durability;
	}
	
	public float getAmplification() {
		return amplification;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RingPartMaterialStats that = (RingPartMaterialStats)o;
		return this.durability == that.getDurability() && this.amplification == that.getAmplification();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(durability,amplification);
	}

}

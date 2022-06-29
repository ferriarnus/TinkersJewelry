package com.ferri.arnus.tinkersjewelry.tools.stats;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;

import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ToolStatId;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class JewelryToolStats {
	
	public static final FloatToolStat DRAW_SPEED = ToolStats.register(new FloatToolStat(new ToolStatId(TinkersJewelry.MODID, "draw_speed"), 0xbd41a2, 5, 1f, 1024));

	public static final FloatToolStat AMPLIFICATION = ToolStats.register(new FloatToolStat(new ToolStatId(TinkersJewelry.MODID, "amplification"), 0xbd41a2, 1, 0.1f, 3));

}

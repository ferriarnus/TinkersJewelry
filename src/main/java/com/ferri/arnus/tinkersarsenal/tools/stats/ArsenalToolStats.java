package com.ferri.arnus.tinkersarsenal.tools.stats;

import com.ferri.arnus.tinkersarsenal.TinkersArsenal;

import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ToolStatId;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class ArsenalToolStats {
	
	public static final FloatToolStat DRAW_SPEED = ToolStats.register(new FloatToolStat(new ToolStatId(TinkersArsenal.MODID,"draw_speed"), 0xbd41a2, 5, 1f, 1024));

	public static final FloatToolStat AMPLIFICATION = ToolStats.register(new FloatToolStat(new ToolStatId(TinkersArsenal.MODID,"amplification"), 0xbd41a2, 5, 1f, 1024));

}

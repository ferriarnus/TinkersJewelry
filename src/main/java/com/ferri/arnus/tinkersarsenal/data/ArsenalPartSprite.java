package com.ferri.arnus.tinkersarsenal.data;

import com.ferri.arnus.tinkersarsenal.TinkersArsenal;

import slimeknights.tconstruct.library.client.data.material.AbstractPartSpriteProvider;

public class ArsenalPartSprite extends AbstractPartSpriteProvider{

	public ArsenalPartSprite() {
		super(TinkersArsenal.MODID);
	}

	@Override
	protected void addAllSpites() {
		buildTool("bow")
			.addHead("bowhandle")
			.addHandle("tool_handle")
			.addBinding("tool_binding");
	}

	@Override
	public String getName() {
		return "Tinkers' Arsenal Materials";
	}

}

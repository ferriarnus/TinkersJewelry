package com.ferri.arnus.tinkersarsenal.items;

public enum CuriosDamageTypes {
	
	HURT_ENTITY("hurt_entity"),
	HURT_PLAYER("hurt_player"),
	BLOCK_BREAK("block_break"),
	NONE("none");

	private final String name;

	CuriosDamageTypes(String name) {
		this.name = name;
	}

}

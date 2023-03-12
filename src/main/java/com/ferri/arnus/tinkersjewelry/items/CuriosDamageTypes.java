package com.ferri.arnus.tinkersjewelry.items;

public enum CuriosDamageTypes {

	NONE("none"),
	HURT_ENTITY("hurt_entity"),
	HURT_PLAYER("hurt_player"),
	BLOCK_BREAK("block_break"),
	MOB_EFFECT("mob_effect"),
	ENCHANTMENT("enchantment");


	private final String name;

	CuriosDamageTypes(String name) {
		this.name = name;
	}

}

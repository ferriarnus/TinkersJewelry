package com.ferri.arnus.playerattributes.operations;

import net.minecraftforge.registries.ForgeRegistryEntry;
public abstract class ModifierOperation extends ForgeRegistryEntry<ModifierOperation> {

    public abstract double handleValue(double curentvalue, double newValue);
}

package com.ferri.arnus.playerattributes.attributes;

import net.minecraft.world.entity.ai.attributes.RangedAttribute;

public class IntAttribute extends RangedAttribute {
    public IntAttribute(String pDescriptionId, double pDefaultValue, double pMin, double pMax) {
        super(pDescriptionId, pDefaultValue, pMin, pMax);
    }

    @Override
    public double sanitizeValue(double pValue) {
        return (int)pValue;
    }
}

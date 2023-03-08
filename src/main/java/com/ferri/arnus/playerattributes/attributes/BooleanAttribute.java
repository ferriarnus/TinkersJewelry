package com.ferri.arnus.playerattributes.attributes;

import net.minecraft.world.entity.ai.attributes.Attribute;

public class BooleanAttribute extends Attribute {
    private boolean value;

    public BooleanAttribute(String pDescriptionId, boolean value) {
        super(pDescriptionId, 0);
        this.value = value;
    }

    @Override
    public double getDefaultValue() {
        return value ? 1 : 0;
    }

    @Override
    public double sanitizeValue(double pValue) {
        return pValue >= 1 ? 1 : 0;
    }
}

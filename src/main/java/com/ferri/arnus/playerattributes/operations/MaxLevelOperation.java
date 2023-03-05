package com.ferri.arnus.playerattributes.operations;

public class MaxLevelOperation extends ModifierOperation{

    @Override
    public double handleValue(double curentvalue, double newValue) {
        return Math.max(curentvalue, newValue);
    }
}


package com.ferri.arnus.playerattributes.operations;

public class BooleanOperation extends ModifierOperation{

    @Override
    public double handleValue(double curentvalue, double newValue) {
        return curentvalue + newValue;
    }
}

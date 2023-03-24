package com.ferri.arnus.tinkersjewelry.tools.modifiers.gem;

import com.ferri.arnus.tinkersjewelry.items.CuriosDamageTypes;

public class NightVisionGemModifier extends AbstractGemModifier{



    @Override
    public CuriosDamageTypes getDamageType() {
        return CuriosDamageTypes.MOB_EFFECT;
    }
}

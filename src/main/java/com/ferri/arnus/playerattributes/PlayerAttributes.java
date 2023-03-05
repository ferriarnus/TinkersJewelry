package com.ferri.arnus.playerattributes;

import com.ferri.arnus.playerattributes.attributes.AttributeRegistry;
import com.ferri.arnus.playerattributes.operations.OperationRegistry;

public class PlayerAttributes {

    public static void register() {
        AttributeRegistry.register();
        OperationRegistry.register();
    }
}

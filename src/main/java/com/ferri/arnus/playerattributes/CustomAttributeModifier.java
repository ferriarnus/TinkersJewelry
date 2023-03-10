package com.ferri.arnus.playerattributes;

import com.ferri.arnus.playerattributes.operations.ModifierOperation;
import com.ferri.arnus.playerattributes.operations.OperationRegistry;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

public class CustomAttributeModifier extends AttributeModifier {
    private double amount;
    private ModifierOperation operation;

    public CustomAttributeModifier(String pName, double pAmount, ModifierOperation operation) {
        super(pName, 0, Operation.ADDITION);//Not used
        this.amount = pAmount;
        this.operation = operation;
    }

    public CustomAttributeModifier(UUID pId, String pName, double pAmount, ModifierOperation operation) {
        super(pId, pName, 0, Operation.ADDITION);
        this.amount = pAmount;
        this.operation = operation;
    }

    public CustomAttributeModifier(UUID pId, Supplier<String> pNameGetter, double pAmount, ModifierOperation operation) {
        super(pId, pNameGetter, 0, Operation.ADDITION);
        this.amount = pAmount;
        this.operation = operation;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public ModifierOperation getModifierOperation() {
        return operation;
    }


    @Override
    public CompoundTag save() {
        CompoundTag compoundtag = new CompoundTag();
        compoundtag.putString("Name", getName());
        compoundtag.putDouble("Amount", getAmount());
        compoundtag.putUUID("UUID", getId());
        compoundtag.putString("COperation", operation.getRegistryName().toString());
        return super.save();
    }

    public static CustomAttributeModifier load(CompoundTag pNbt) {
        String name = pNbt.getString("Name");
        double amount = pNbt.getDouble("Amount");
        UUID id = pNbt.getUUID("UUID");
        ResourceLocation rl = new ResourceLocation(pNbt.getString("COperation"));
        Optional<Holder<ModifierOperation>> holder = OperationRegistry.OPERATIONS_REGISTRY.get().getHolder(rl);
        if (holder.isEmpty()) {
            throw new IllegalArgumentException("");
        }
        return new CustomAttributeModifier(id, name, amount, holder.get().value());
    }
}

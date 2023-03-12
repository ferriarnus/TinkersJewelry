package com.ferri.arnus.playerattributes.events;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.Event;

public class EnchantmentSimulateEvent extends Event {

    private final LivingEntity entity;
    private final Enchantment enchantment;
    private int level;

    public EnchantmentSimulateEvent(Enchantment enchantment, LivingEntity entity, int level) {
        this.entity = entity;
        this.enchantment = enchantment;
        this.level = level;
    }

    public LivingEntity getEntity() {
        return entity;
    }

    public Enchantment getEnchantment() {
        return enchantment;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

package com.ferri.arnus.tinkersarsenal;

import com.ferri.arnus.tinkersarsenal.items.ItemRegistry;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = TinkersArsenal.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

	@SubscribeEvent
	static void cientSetup(FMLClientSetupEvent event) {
		ItemProperties.register(ItemRegistry.bow.get(), new ResourceLocation("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
			if (p_174637_ == null) {
				return 0.0F;
			} else {
				return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 20.0F;
			}
		});
		ItemProperties.register(ItemRegistry.bow.get(), new ResourceLocation("pulling"), (p_174630_, p_174631_, p_174632_, p_174633_) -> {
	         return p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F;
	      });
	}
	
}

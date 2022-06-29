package com.ferri.arnus.tinkersjewelry;

import org.slf4j.Logger;

import com.ferri.arnus.tinkersjewelry.data.JewelryMaterialData;
import com.ferri.arnus.tinkersjewelry.data.JewelryMaterialRecipe;
import com.ferri.arnus.tinkersjewelry.data.JewelryMaterialRenderInfo;
import com.ferri.arnus.tinkersjewelry.data.JewelryMaterialSprite;
import com.ferri.arnus.tinkersjewelry.data.JewelryMaterialStatsData;
import com.ferri.arnus.tinkersjewelry.data.JewelryMaterialTraitData;
import com.ferri.arnus.tinkersjewelry.data.JewelryPartSprite;
import com.ferri.arnus.tinkersjewelry.data.JewelryStationSlotLayout;
import com.ferri.arnus.tinkersjewelry.data.JewelryToolDefinitionData;
import com.ferri.arnus.tinkersjewelry.data.JewelryToolsRecipe;
import com.ferri.arnus.tinkersjewelry.items.ItemRegistry;
import com.ferri.arnus.tinkersjewelry.tools.modifiers.JewelryModifiers;
import com.ferri.arnus.tinkersjewelry.tools.stats.GemMaterialStats;
import com.ferri.arnus.tinkersjewelry.tools.stats.RingPartMaterialStats;
import com.mojang.logging.LogUtils;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import slimeknights.tconstruct.library.client.data.material.GeneratorPartTextureJsonGenerator;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.library.materials.MaterialRegistry;
import slimeknights.tconstruct.tools.data.material.MaterialDataProvider;
import slimeknights.tconstruct.tools.data.sprite.TinkerMaterialSpriteProvider;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

@Mod(TinkersJewelry.MODID)
public class TinkersJewelry {
	// Directly reference a slf4j logger
	private static final Logger LOGGER = LogUtils.getLogger();
	public static final String MODID = "tinkersjewelry";
	
	public TinkersJewelry() { 
		
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(EventPriority.LOWEST, this::gatherData);
        modEventBus.addListener(this::sendImc);
		
		ItemRegistry.registerItems();
		JewelryModifiers.registerModifiers();
	}
	
	public void sendImc(InterModEnqueueEvent evt) {
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.CHARM.getMessageBuilder().build());
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.RING.getMessageBuilder().size(2).build());
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.BELT.getMessageBuilder().build());
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.BODY.getMessageBuilder().build());
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.HEAD.getMessageBuilder().build());
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.NECKLACE.getMessageBuilder().build());
		
		MaterialRegistry.getInstance().registerStatType(RingPartMaterialStats.DEFAULT, RingPartMaterialStats.class, RingPartMaterialStats::new);
		MaterialRegistry.getInstance().registerStatType(GemMaterialStats.DEFAULT, GemMaterialStats.class, GemMaterialStats::new);
	}
	
	public void gatherData(final GatherDataEvent event) { 
		DataGenerator generator = event.getGenerator();
		if (event.includeServer()) {
        	generator.addProvider(new JewelryToolsRecipe(generator));
        	generator.addProvider(new JewelryMaterialRecipe(generator));
			MaterialDataProvider materials = new MaterialDataProvider(generator);
			JewelryMaterialData newMaterials = new JewelryMaterialData(generator);
        	generator.addProvider(materials);
        	generator.addProvider(newMaterials);
        	//generator.addProvider(new MaterialStatsDataProvider(generator, materials));
        	generator.addProvider(new JewelryMaterialStatsData(generator, newMaterials));
        	generator.addProvider(new JewelryMaterialTraitData(generator, newMaterials));
			generator.addProvider(new JewelryToolDefinitionData(generator));
			generator.addProvider(new JewelryStationSlotLayout(generator));
		}
		if (event.includeClient()) {
        	TinkerMaterialSpriteProvider materialSprites = new TinkerMaterialSpriteProvider();
        	JewelryMaterialSprite newMaterialSprites = new JewelryMaterialSprite();
        	JewelryPartSprite partSprites = new JewelryPartSprite();
        	ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        	 generator.addProvider(new JewelryMaterialRenderInfo(generator, materialSprites));
             generator.addProvider(new GeneratorPartTextureJsonGenerator(generator, TinkersJewelry.MODID, partSprites));
			generator.addProvider(new MaterialPartTextureGenerator(generator, existingFileHelper, partSprites, materialSprites, newMaterialSprites));
			
		}
	}
	
}

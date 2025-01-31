package com.ferri.arnus.tinkersjewelry;

import com.ferri.arnus.tinkersjewelry.data.*;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.data.event.GatherDataEvent;
import org.slf4j.Logger;

import com.ferri.arnus.tinkersjewelry.items.ItemRegistry;
import com.ferri.arnus.tinkersjewelry.tools.modifiers.JewelryModifiers;
import com.ferri.arnus.tinkersjewelry.tools.stats.GemMaterialStats;
import com.ferri.arnus.tinkersjewelry.tools.stats.BlankBandMaterialStats;
import com.mojang.logging.LogUtils;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import slimeknights.tconstruct.library.client.data.material.GeneratorPartTextureJsonGenerator;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.library.materials.MaterialRegistry;
import slimeknights.tconstruct.tools.data.material.MaterialDataProvider;
import slimeknights.tconstruct.tools.data.material.MaterialIds;
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

		ForgeMod.enableMilkFluid();
	}
	
	public void sendImc(InterModEnqueueEvent evt) {
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.CHARM.getMessageBuilder().build());
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.RING.getMessageBuilder().size(2).build());
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.BELT.getMessageBuilder().build());
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.BODY.getMessageBuilder().build());
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.HEAD.getMessageBuilder().build());
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.NECKLACE.getMessageBuilder().build());
		
		MaterialRegistry.getInstance().registerStatType(BlankBandMaterialStats.TYPE);
		MaterialRegistry.getInstance().registerStatType(GemMaterialStats.TYPE);
	}
	
	public void gatherData(final GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		boolean server = event.includeServer();
		boolean client = event.includeClient();
		generator.addProvider(server, new JewelryToolsRecipe(generator.getPackOutput()));
		generator.addProvider(server, new JewelryMaterialRecipe(generator.getPackOutput()));
		generator.addProvider(server, new JewelrySmeltryRecipe(generator.getPackOutput()));
		JewelryMaterialData newMaterials = new JewelryMaterialData(generator.getPackOutput());
		generator.addProvider(server, newMaterials);
		generator.addProvider(server, new JewelryMaterialStatsData(generator.getPackOutput(), newMaterials));
		generator.addProvider(server, new JewelryMaterialTraitData(generator.getPackOutput(), newMaterials));
		generator.addProvider(server, new JewelryToolDefinitionData(generator.getPackOutput()));
		generator.addProvider(server, new JewelryStationSlotLayout(generator.getPackOutput()));

		TinkerMaterialSpriteProvider materialSprites = new TinkerMaterialSpriteProvider();
		JewelryMaterialSprite newMaterialSprites = new JewelryMaterialSprite();
		JewelryPartSprite partSprites = new JewelryPartSprite();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

		GeneratorPartTextureJsonGenerator.StatOverride.Builder builder = new GeneratorPartTextureJsonGenerator.StatOverride.Builder();
		builder.add(BlankBandMaterialStats.ID, MaterialIds.copper.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.iron.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.gold.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.osmium.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.tungsten.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.platinum.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.silver.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.lead.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.slimesteel.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.amethystBronze.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.nahuatl.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.pigIron.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.roseGold.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.steel.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.bronze.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.constantan.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.invar.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.necronium.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.electrum.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.platedSlimewood.getId());
		builder.add(BlankBandMaterialStats.ID, MaterialIds.manyullyn.getId());
		GeneratorPartTextureJsonGenerator.StatOverride overrides = builder.build();

		generator.addProvider(client, new JewelryMaterialRenderInfo(generator.getPackOutput(), newMaterialSprites, existingFileHelper));
		generator.addProvider(client, new GeneratorPartTextureJsonGenerator(generator.getPackOutput(), TinkersJewelry.MODID, partSprites, overrides));
		generator.addProvider(client, new MaterialPartTextureGenerator(generator.getPackOutput(), existingFileHelper, partSprites, overrides, materialSprites, newMaterialSprites));
	}
	
}

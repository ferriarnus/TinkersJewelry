package com.ferri.arnus.tinkersarsenal;

import org.slf4j.Logger;

import com.ferri.arnus.tinkersarsenal.blockentities.BlockEntityRegistry;
import com.ferri.arnus.tinkersarsenal.blocks.BlockRegistry;
import com.ferri.arnus.tinkersarsenal.data.ArsenalMaterialData;
import com.ferri.arnus.tinkersarsenal.data.ArsenalMaterialRecipe;
import com.ferri.arnus.tinkersarsenal.data.ArsenalMaterialStatsData;
import com.ferri.arnus.tinkersarsenal.data.ArsenalMaterialTraitData;
import com.ferri.arnus.tinkersarsenal.data.ArsenalPartSprite;
import com.ferri.arnus.tinkersarsenal.data.ArsenalStationSlotLayout;
import com.ferri.arnus.tinkersarsenal.data.ArsenalToolDefinitionData;
import com.ferri.arnus.tinkersarsenal.data.ArsenalToolsRecipe;
import com.ferri.arnus.tinkersarsenal.items.ItemRegistry;
import com.ferri.arnus.tinkersarsenal.tools.modifiers.ArsenalModifiers;
import com.ferri.arnus.tinkersarsenal.tools.stats.GemMaterialStats;
import com.ferri.arnus.tinkersarsenal.tools.stats.RingPartMaterialStats;
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
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.library.materials.MaterialRegistry;
import slimeknights.tconstruct.tools.data.material.MaterialDataProvider;
import slimeknights.tconstruct.tools.data.sprite.TinkerMaterialSpriteProvider;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TinkersArsenal.MODID)
public class TinkersArsenal
{
	// Directly reference a slf4j logger
	private static final Logger LOGGER = LogUtils.getLogger();
	public static final String MODID = "tinkersarsenal";
	
	public TinkersArsenal() { 
		
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(EventPriority.LOWEST, this::gatherData);
        modEventBus.addListener(this::sendImc);
		
		ItemRegistry.registerItems();
		BlockRegistry.registerBlocks();
		BlockEntityRegistry.registerBlockEntities();
		ArsenalModifiers.registerModifiers();
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
        	generator.addProvider(new ArsenalToolsRecipe(generator));
        	generator.addProvider(new ArsenalMaterialRecipe(generator));
			MaterialDataProvider materials = new MaterialDataProvider(generator);
			ArsenalMaterialData newMaterials = new ArsenalMaterialData(generator);
        	generator.addProvider(materials);
        	generator.addProvider(newMaterials);
        	//generator.addProvider(new MaterialStatsDataProvider(generator, materials));
        	generator.addProvider(new ArsenalMaterialStatsData(generator, newMaterials));
        	generator.addProvider(new ArsenalMaterialTraitData(generator, newMaterials));
			generator.addProvider(new ArsenalToolDefinitionData(generator));
			generator.addProvider(new ArsenalStationSlotLayout(generator));
		}
		if (event.includeClient()) {
        	TinkerMaterialSpriteProvider materialSprites = new TinkerMaterialSpriteProvider();
        	ArsenalPartSprite partSprites = new ArsenalPartSprite();
        	ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
			generator.addProvider(new MaterialPartTextureGenerator(generator, existingFileHelper, partSprites, materialSprites));
			
		}
	}
	
}

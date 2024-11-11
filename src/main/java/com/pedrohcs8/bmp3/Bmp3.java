package com.pedrohcs8.bmp3;

import com.mojang.logging.LogUtils;
import com.pedrohcs8.bmp3.events.ModEvents;
import com.pedrohcs8.bmp3.init.EntityInit;
import com.pedrohcs8.bmp3.init.ModBlocks;
import com.pedrohcs8.bmp3.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.FolderRepositorySource;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.repository.RepositorySource;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.validation.DirectoryValidator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import org.apache.commons.io.filefilter.PathMatcherFileFilter;
import org.slf4j.Logger;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Bmp3.MOD_ID)
public class Bmp3
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "bmp3";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public Bmp3()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        EntityInit.entities.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);


    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(ModItems.celular);
            event.accept(ModBlocks.saco_bloom_block);
            event.accept(ModBlocks.saco_bloom_vazio_block);
        }
    }
}

package com.pedrohcs8.bmp3.events;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.client.model.DirtBikeModel;
import com.pedrohcs8.bmp3.client.renderer.DirtBikeRenderer;
import com.pedrohcs8.bmp3.entities.DirtBikeEntity;
import com.pedrohcs8.bmp3.init.EntityInit;
import com.pedrohcs8.bmp3.network.PacketHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Bmp3.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            PacketHandler.register();
        });
    }

    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityInit.dirt_bike_entity.get(), DirtBikeEntity.createDirtBikeAttributes().build());
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.dirt_bike_entity.get(), DirtBikeRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(DirtBikeModel.LAYER_LOCATION, DirtBikeModel::createBodyLayer);
    }
}

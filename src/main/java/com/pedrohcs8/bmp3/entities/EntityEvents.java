package com.pedrohcs8.bmp3.entities;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.entities.model.DirtBikeModel;
import com.pedrohcs8.bmp3.entities.model.MineCarModel;
import com.pedrohcs8.bmp3.entities.renderer.DirtBikeRenderer;
import com.pedrohcs8.bmp3.entities.renderer.MineCarRenderer;
import com.pedrohcs8.bmp3.init.EntityInit;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Bmp3.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityEvents {
    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityInit.dirt_bike_entity.get(), DirtBikeEntity.createDirtBikeAttributes().build());
        event.put(EntityInit.mine_car_entity.get(), MineCarEntity.createMineCarAttributes().build());
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.dirt_bike_entity.get(), DirtBikeRenderer::new);
        event.registerEntityRenderer(EntityInit.mine_car_entity.get(), MineCarRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(DirtBikeModel.LAYER_LOCATION, DirtBikeModel::createBodyLayer);
        event.registerLayerDefinition(MineCarModel.LAYER_LOCATION, MineCarModel::createBodyLayer);
    }
}

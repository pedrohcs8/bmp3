package com.pedrohcs8.bmp3.events;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.entities.model.DirtBikeModel;
import com.pedrohcs8.bmp3.entities.model.MineCarModel;
import com.pedrohcs8.bmp3.entities.renderer.DirtBikeRenderer;
import com.pedrohcs8.bmp3.entities.renderer.MineCarRenderer;
import com.pedrohcs8.bmp3.entities.DirtBikeEntity;
import com.pedrohcs8.bmp3.entities.MineCarEntity;
import com.pedrohcs8.bmp3.init.EntityInit;
import com.pedrohcs8.bmp3.network.PacketHandler;
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
}

package com.pedrohcs8.bmp3.events;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.commands.OpenDealershipCommand;
import com.pedrohcs8.bmp3.commands.bank.AddMoneyCommand;
import com.pedrohcs8.bmp3.commands.bank.RemoveMoneyCommand;
import com.pedrohcs8.bmp3.commands.npc.BuyItemCommand;
import com.pedrohcs8.bmp3.commands.npc.SellItemCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Bmp3.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonForgeEvents {
    public static boolean handcuffed = false;

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event){
        AddMoneyCommand.register(event.getDispatcher());
        RemoveMoneyCommand.register(event.getDispatcher());
        BuyItemCommand.register(event.getDispatcher(), event.getBuildContext());
        SellItemCommand.register(event.getDispatcher(), event.getBuildContext());
        OpenDealershipCommand.register(event.getDispatcher());
    }

    // TODO: WRONG BUS
//    @SubscribeEvent
//    public static void renderplayereventpos(RenderPlayerEvent.Post event) {
////        if (handcuffed) {
////            event.getRenderer().getModel().leftArm.setRotation();
////            event.getRenderer().getModel().rightArm.setRotation();
////        }
//    }
}

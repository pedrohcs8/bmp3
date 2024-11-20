package com.pedrohcs8.bmp3.events;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.capabilities.Bank.BankMoneyProvider;
import com.pedrohcs8.bmp3.capabilities.Whatsapp.WAAddedPlayersProvider;
import com.pedrohcs8.bmp3.init.ModItems;
import com.pedrohcs8.bmp3.items.CelularItem;
import com.pedrohcs8.bmp3.network.PacketHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Bmp3.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onPlayerDrops(ItemTossEvent event) {
        if (event.getEntity().getItem().getItem() instanceof CelularItem) {
            event.getPlayer().addItem(new ItemStack(ModItems.celular.get(), 1));
            event.setCanceled(true);
        }
    }
}

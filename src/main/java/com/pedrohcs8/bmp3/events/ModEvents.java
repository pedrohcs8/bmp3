package com.pedrohcs8.bmp3.events;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.capabilities.Whatsapp.WAAddedPlayersProvider;
import com.pedrohcs8.bmp3.network.PacketHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Bmp3.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            if (!event.getObject().getCapability(WAAddedPlayersProvider.player_contatos).isPresent()) {
                event.addCapability(ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "wa_added"), new WAAddedPlayersProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        event.getOriginal().reviveCaps();
        event.getOriginal().getCapability(WAAddedPlayersProvider.player_contatos).ifPresent(oldStore -> {
            System.out.println(oldStore.getAddedPlayers());
            event.getEntity().getCapability(WAAddedPlayersProvider.player_contatos).ifPresent(newStore -> {
                newStore.copyFrom(oldStore.getAddedPlayers());
            });
        });


        event.getOriginal().invalidateCaps();
    }
}

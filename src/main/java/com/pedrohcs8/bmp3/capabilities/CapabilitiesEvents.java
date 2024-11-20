package com.pedrohcs8.bmp3.capabilities;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.capabilities.Bank.BankMoneyProvider;
import com.pedrohcs8.bmp3.capabilities.Dealer.VehicleCapabilityProvider;
import com.pedrohcs8.bmp3.capabilities.Whatsapp.WAAddedPlayersProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Bmp3.MOD_ID)
public class CapabilitiesEvents {
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            if (!event.getObject().getCapability(WAAddedPlayersProvider.player_contatos).isPresent()) {
                event.addCapability(ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "wa_added"), new WAAddedPlayersProvider());
            }

            if (!event.getObject().getCapability(BankMoneyProvider.bank_money).isPresent()) {
                event.addCapability(ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "bank_added"), new BankMoneyProvider());
            }

            if (!event.getObject().getCapability(VehicleCapabilityProvider.player_vehicles).isPresent()) {
                event.addCapability(ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "vehicles_added"), new VehicleCapabilityProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        event.getOriginal().reviveCaps();

        event.getOriginal().getCapability(WAAddedPlayersProvider.player_contatos).ifPresent(oldStore -> {
            event.getEntity().getCapability(WAAddedPlayersProvider.player_contatos).ifPresent(newStore -> {
                newStore.copyFrom(oldStore.getAddedPlayers());
            });
        });

        event.getOriginal().getCapability(BankMoneyProvider.bank_money).ifPresent(oldStore -> {
            event.getEntity().getCapability(BankMoneyProvider.bank_money).ifPresent(newStore -> {
                newStore.copyFrom(oldStore);
            });
        });

        event.getOriginal().getCapability(VehicleCapabilityProvider.player_vehicles).ifPresent(oldStore -> {
            event.getEntity().getCapability(VehicleCapabilityProvider.player_vehicles).ifPresent(newStore -> {
                newStore.copyFrom(oldStore.getVehicles());
            });
        });


        event.getOriginal().invalidateCaps();
    }
}

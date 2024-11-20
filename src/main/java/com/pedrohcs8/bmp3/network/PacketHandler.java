package com.pedrohcs8.bmp3.network;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.network.bank.money.C2SRemoveMoney;
import com.pedrohcs8.bmp3.network.bank.money.S2CAddMoney;
import com.pedrohcs8.bmp3.network.bank.money.S2CRemoveMoney;
import com.pedrohcs8.bmp3.network.bank.pay.C2SPay;
import com.pedrohcs8.bmp3.network.bank.pay.S2CPay;
import com.pedrohcs8.bmp3.network.dealer.C2SSpawnVehicle;
import com.pedrohcs8.bmp3.network.whatsapp.C2SMessageSend;
import com.pedrohcs8.bmp3.network.whatsapp.S2CMessageSend;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.SimpleChannel;

public class PacketHandler {
    private static final SimpleChannel instance =
            ChannelBuilder.named(ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "main"))
                    .serverAcceptedVersions((status, version) -> true)
                    .clientAcceptedVersions((status, version) -> true)
                    .networkProtocolVersion(1)
                    .simpleChannel();

    public static void register() {
        // Whatsapp Packets
        instance.messageBuilder(C2SMessageSend.class, NetworkDirection.PLAY_TO_SERVER)
                .encoder(C2SMessageSend::encode)
                .decoder(C2SMessageSend::new)
                .consumerMainThread(C2SMessageSend::handle)
                .add();

        instance.messageBuilder(S2CMessageSend.class, NetworkDirection.PLAY_TO_CLIENT)
                .encoder(S2CMessageSend::encode)
                .decoder(S2CMessageSend::new)
                .consumerMainThread(S2CMessageSend::handle)
                .add();

        // Bank Packets

        instance.messageBuilder(C2SPay.class, NetworkDirection.PLAY_TO_SERVER)
                .encoder(C2SPay::encode)
                .decoder(C2SPay::new)
                .consumerMainThread(C2SPay::handle)
                .add();

        instance.messageBuilder(S2CPay.class, NetworkDirection.PLAY_TO_CLIENT)
                .encoder(S2CPay::encode)
                .decoder(S2CPay::new)
                .consumerMainThread(S2CPay::handle)
                .add();

        instance.messageBuilder(S2CAddMoney.class, NetworkDirection.PLAY_TO_CLIENT)
                .encoder(S2CAddMoney::encode)
                .decoder(S2CAddMoney::new)
                .consumerMainThread(S2CAddMoney::handle)
                .add();

        instance.messageBuilder(C2SRemoveMoney.class, NetworkDirection.PLAY_TO_SERVER)
                .encoder(C2SRemoveMoney::encode)
                .decoder(C2SRemoveMoney::new)
                .consumerMainThread(C2SRemoveMoney::handle)
                .add();

        instance.messageBuilder(S2CRemoveMoney.class, NetworkDirection.PLAY_TO_CLIENT)
                .encoder(S2CRemoveMoney::encode)
                .decoder(S2CRemoveMoney::new)
                .consumerMainThread(S2CRemoveMoney::handle)
                .add();

        // Dealer Packets

        instance.messageBuilder(C2SSpawnVehicle.class, NetworkDirection.PLAY_TO_SERVER)
                .encoder(C2SSpawnVehicle::encode)
                .decoder(C2SSpawnVehicle::new)
                .consumerMainThread(C2SSpawnVehicle::handle)
                .add();
    }

    public static void sendToServer(Object msg) {
        instance.send(msg, PacketDistributor.SERVER.noArg());
    }

    public static void sendToAllClients(Object msg) {
        instance.send(msg, PacketDistributor.ALL.noArg());
    }

    public static void sendToSpecificPlayer(Object msg, ServerPlayer player) {
        instance.send(msg, PacketDistributor.PLAYER.with(player));
    }
}

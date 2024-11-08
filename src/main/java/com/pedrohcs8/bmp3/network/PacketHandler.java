package com.pedrohcs8.bmp3.network;

import com.pedrohcs8.bmp3.Bmp3;
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

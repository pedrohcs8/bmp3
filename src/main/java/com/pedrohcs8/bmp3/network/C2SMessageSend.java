package com.pedrohcs8.bmp3.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.network.CustomPayloadEvent;

public class C2SMessageSend {
    private final String message;
    private final String playerName;
    private final String author;

    public C2SMessageSend(String message, String playerName, String author) {
        this.message = message;
        this.playerName = playerName;
        this.author = author;
    }

    public C2SMessageSend(FriendlyByteBuf buffer) {
        this(buffer.readUtf(), buffer.readUtf(), buffer.readUtf());
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeUtf(this.message);
        buffer.writeUtf(this.playerName);
        buffer.writeUtf(this.author);
    }

    public void handle(CustomPayloadEvent.Context context) {
        ServerPlayer player = context.getSender().getServer().getPlayerList().getPlayerByName(this.playerName);
        PacketHandler.sendToSpecificPlayer(new S2CMessageSend(this.message, this.playerName, this.author), player);
    }
}

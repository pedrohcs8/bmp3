package com.pedrohcs8.bmp3.network;

import com.pedrohcs8.bmp3.Utils;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.event.network.CustomPayloadEvent;

public class S2CMessageSend {
    private final String message;
    private final String playerName;
    private final String author;

    public S2CMessageSend(String message, String playerName, String author) {
        this.message = message;
        this.playerName = playerName;
        this.author = author;
    }

    public S2CMessageSend(FriendlyByteBuf buffer) {
        this(buffer.readUtf(), buffer.readUtf(), buffer.readUtf());
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeUtf(this.message);
        buffer.writeUtf(this.playerName);
        buffer.writeUtf(this.author);
    }

    public void handle(CustomPayloadEvent.Context context) {
        System.out.println("client");
        Utils.createMessageFile(author);
        Utils.writeToMsgFile(author, author, message);
    }
}
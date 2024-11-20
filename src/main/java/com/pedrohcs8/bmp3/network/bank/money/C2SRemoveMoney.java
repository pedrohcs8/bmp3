package com.pedrohcs8.bmp3.network.bank.money;

import com.pedrohcs8.bmp3.network.PacketHandler;
import com.pedrohcs8.bmp3.network.whatsapp.S2CMessageSend;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.network.CustomPayloadEvent;

public class C2SRemoveMoney {
    private final String playerName;
    private final int money;
    private final String itemName;
    private final int qntd;

    public C2SRemoveMoney(String playerName, int money, String itemName, int qntd) {
        this.playerName = playerName;
        this.money = money;
        this.itemName = itemName;
        this.qntd = qntd;
    }

    public C2SRemoveMoney(FriendlyByteBuf buffer) {
        this(buffer.readUtf(), buffer.readInt(), buffer.readUtf(), buffer.readInt());
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeUtf(this.playerName);
        buffer.writeInt(this.money);
        buffer.writeUtf(this.itemName);
        buffer.writeInt(this.qntd);
    }

    public void handle(CustomPayloadEvent.Context context) {
        ServerPlayer player = context.getSender().getServer().getPlayerList().getPlayerByName(this.playerName);
        PacketHandler.sendToSpecificPlayer(new S2CRemoveMoney(this.money, this.itemName, this.qntd), player);
    }
}

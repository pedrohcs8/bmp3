package com.pedrohcs8.bmp3.network.bank.pay;

import com.pedrohcs8.bmp3.capabilities.Bank.BankMoneyProvider;
import com.pedrohcs8.bmp3.network.PacketHandler;
import com.pedrohcs8.bmp3.network.whatsapp.S2CMessageSend;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.network.CustomPayloadEvent;

public class C2SPay {
    private final String playerName;
    private final int money;

    public C2SPay(String playerName, int money) {
        this.playerName = playerName;
        this.money = money;
    }

    public C2SPay(FriendlyByteBuf buffer) {
        this(buffer.readUtf(), buffer.readInt());
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeUtf(this.playerName);
        buffer.writeInt(this.money);
    }

    public void handle(CustomPayloadEvent.Context context) {
        ServerPlayer player = context.getSender().getServer().getPlayerList().getPlayerByName(this.playerName);
        PacketHandler.sendToSpecificPlayer(new S2CPay(this.money), player);
    }
}

package com.pedrohcs8.bmp3.network.bank.money;

import com.pedrohcs8.bmp3.capabilities.Bank.BankMoneyProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.event.network.CustomPayloadEvent;

public class S2CAddMoney {
    private final int money;

    public S2CAddMoney(int money) {
        this.money = money;
    }

    public S2CAddMoney(FriendlyByteBuf buffer) {
        this(buffer.readInt());
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeInt(this.money);
    }

    public void handle(CustomPayloadEvent.Context context) {
        Minecraft.getInstance().player.getCapability(BankMoneyProvider.bank_money).ifPresent(money -> {
            money.addMoney(this.money);
        });
    }
}

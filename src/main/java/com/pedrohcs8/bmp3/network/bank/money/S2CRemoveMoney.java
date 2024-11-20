package com.pedrohcs8.bmp3.network.bank.money;

import com.pedrohcs8.bmp3.capabilities.Bank.BankMoneyProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.commands.arguments.item.ItemInput;
import net.minecraft.commands.arguments.item.ItemParser;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.network.CustomPayloadEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class S2CRemoveMoney {
    private final int money;
    private final String itemName;
    private final int qntd;

    public S2CRemoveMoney(int money, String itemName, int qntd) {
        this.money = money;
        this.itemName = itemName;
        this.qntd = qntd;
    }

    public S2CRemoveMoney(FriendlyByteBuf buffer) {
        this(buffer.readInt(), buffer.readUtf(), buffer.readInt());
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeInt(this.money);
        buffer.writeUtf(this.itemName);
        buffer.writeInt(this.qntd);
    }

    public void handle(CustomPayloadEvent.Context context) {
        Minecraft.getInstance().player.getCapability(BankMoneyProvider.bank_money).ifPresent(money -> {
            if (money.getMoney() - this.money < 0) {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Você não tem dinheiro para isto."));
                return;
            }

            if (!this.itemName.isEmpty()) {
                String namespace = this.itemName.split(":")[0];
                String path = this.itemName.split(":")[1];
                Item addItem = ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath(namespace, path));

                Minecraft.getInstance().player.getInventory().add(new ItemStack(addItem, qntd));
            }

            money.removeMoney(this.money);
        });
    }
}

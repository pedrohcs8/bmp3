package com.pedrohcs8.bmp3.capabilities.Bank;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;

@AutoRegisterCapability
public class BankMoney {
    private int money = 0;

    public int getMoney() {
        return money;
    }

    public void addMoney(int add_money) {
        money = money + add_money;
    }

    public void removeMoney(int remove_money) {
        money = money - remove_money;
    }

    public void copyFrom(BankMoney oldMoney) {
        this.money = oldMoney.getMoney();
    }

    public void saveNBTData(CompoundTag nbt) {;
        nbt.putInt("money", money);
    }

    public void loadNBTData(CompoundTag nbt) {
        money = nbt.getInt("money");
    }
}

package com.pedrohcs8.bmp3.capabilities.Bank;

import com.pedrohcs8.bmp3.capabilities.Whatsapp.WAAddedPlayers;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BankMoneyProvider implements ICapabilityProvider, INBTSerializable<CompoundTag>  {
    public static Capability<BankMoney> bank_money = CapabilityManager.get(new CapabilityToken<BankMoney>() {});

    private BankMoney bankMoney = null;
    private final LazyOptional<BankMoney> optional = LazyOptional.of(this::createBankMoney);

    private BankMoney createBankMoney() {
        if (this.bankMoney == null) {
            this.bankMoney = new BankMoney();
        }

        return this.bankMoney;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == bank_money) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT(HolderLookup.Provider registryAccess) {
        CompoundTag nbt = new CompoundTag();
        createBankMoney().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider registryAccess, CompoundTag nbt) {
        createBankMoney().loadNBTData(nbt);
    }
}

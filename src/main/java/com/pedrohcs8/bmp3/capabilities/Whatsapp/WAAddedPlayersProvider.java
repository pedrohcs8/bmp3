package com.pedrohcs8.bmp3.capabilities.Whatsapp;

import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WAAddedPlayersProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<WAAddedPlayers> player_contatos = CapabilityManager.get(new CapabilityToken<WAAddedPlayers>() {});

    private WAAddedPlayers waAddedPlayers = null;
    private final LazyOptional<WAAddedPlayers> optional = LazyOptional.of(this::createWaContatos);

    private WAAddedPlayers createWaContatos() {
        if (this.waAddedPlayers == null) {
            this.waAddedPlayers = new WAAddedPlayers();
        }

        return this.waAddedPlayers;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == player_contatos) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT(HolderLookup.Provider registryAccess) {
        CompoundTag nbt = new CompoundTag();
        createWaContatos().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider registryAccess, CompoundTag nbt) {
        createWaContatos().loadNBTData(nbt);
    }
}

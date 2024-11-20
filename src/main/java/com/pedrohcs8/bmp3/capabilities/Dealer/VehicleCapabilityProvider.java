package com.pedrohcs8.bmp3.capabilities.Dealer;

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

public class VehicleCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<VehiclesCapability> player_vehicles = CapabilityManager.get(new CapabilityToken<VehiclesCapability>() {});

    private VehiclesCapability vehiclesList = null;
    private final LazyOptional<VehiclesCapability> optional = LazyOptional.of(this::createVehiclesList);

    private VehiclesCapability createVehiclesList() {
        if (this.vehiclesList == null) {
            this.vehiclesList = new VehiclesCapability();
        }

        return this.vehiclesList;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == player_vehicles) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT(HolderLookup.Provider registryAccess) {
        CompoundTag nbt = new CompoundTag();
        createVehiclesList().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider registryAccess, CompoundTag nbt) {
        createVehiclesList().loadNBTData(nbt);
    }
}

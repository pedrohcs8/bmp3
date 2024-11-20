package com.pedrohcs8.bmp3.capabilities.Dealer;

import net.minecraft.nbt.CompoundTag;

import java.util.ArrayList;
import java.util.List;

public class VehiclesCapability {
    private static List<String> vehiclesOwned = new ArrayList<>();
    public final int maxAddedPlayers = 5;

    public List<String> getVehicles() {
        return vehiclesOwned;
    }

    public void addVehicle(String vehicle) {
        vehiclesOwned.add(vehicle);
    }

    public String removeVehicle(String vehicle) {
        return "A";
    }

    public boolean isIncluded(String vehicle) {
        for (int i = 0; i < vehiclesOwned.size(); i++) {
            if (vehiclesOwned.get(i) == vehicle) {
                return true;
            }
        }

        return false;
    }

    public void copyFrom(List<String> oldList) {
        vehiclesOwned = oldList;
    }

    public void saveNBTData(CompoundTag nbt) {;
        for (int i = 0; i < vehiclesOwned.size(); i++) {
            nbt.putString("vehicle" + i, vehiclesOwned.get(i));
        }
    }

    public void loadNBTData(CompoundTag nbt) {
        List<String> fetchedVehicles = new ArrayList<>();

        for (int i = 0; i < maxAddedPlayers; i++) {
            String fetchedVehicle = nbt.getString("vehicle" + i);
            if (!fetchedVehicle.isEmpty()) {
                fetchedVehicles.add(fetchedVehicle);
            }
        }

        vehiclesOwned = fetchedVehicles;
    }
}

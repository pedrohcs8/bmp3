package com.pedrohcs8.bmp3.capabilities.Whatsapp;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;

import java.util.ArrayList;
import java.util.List;

@AutoRegisterCapability
public class WAAddedPlayers {
    private static List<String> addedPlayersList = new ArrayList<>();
    public final int maxAddedPlayers = 5;

    public List<String> getAddedPlayers() {
        return addedPlayersList;
    }

    public void addPlayer(String playerName) {
        addedPlayersList.add(playerName);
    }

    public String removePlayer(String playerName) {
        return "A";
    }

    public boolean isIncluded(String playerName) {
        for (int i = 0; i < addedPlayersList.size(); i++) {
            if (addedPlayersList.get(i) == playerName) {
                return true;
            }
        }

        return false;
    }

    public void copyFrom(List<String> oldList) {
        addedPlayersList = oldList;
    }

    public void saveNBTData(CompoundTag nbt) {;
        for (int i = 0; i < addedPlayersList.size(); i++) {
            nbt.putString("contato" + i, addedPlayersList.get(i));
        }
    }

    public void loadNBTData(CompoundTag nbt) {
        List<String> fetchedPlayers = new ArrayList<>();

       for (int i = 0; i < maxAddedPlayers; i++) {
            String fetchedContato = nbt.getString("contato" + i);
            if (!fetchedContato.isEmpty()) {
                fetchedPlayers.add(fetchedContato);
            }
        }

        addedPlayersList = fetchedPlayers;
    }
}

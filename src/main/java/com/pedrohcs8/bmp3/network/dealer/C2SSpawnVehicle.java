package com.pedrohcs8.bmp3.network.dealer;

import com.pedrohcs8.bmp3.entities.DirtBikeEntity;
import com.pedrohcs8.bmp3.init.EntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraftforge.event.network.CustomPayloadEvent;

public class C2SSpawnVehicle {
    private final String playerName;
    private final String vehicle;
    private final BlockPos pos;

    public C2SSpawnVehicle(String playerName, String vehicle, BlockPos pos) {
        this.playerName = playerName;
        this.vehicle = vehicle;
        this.pos = pos;
    }

    public C2SSpawnVehicle(FriendlyByteBuf buffer) {
        this(buffer.readUtf(), buffer.readUtf(), buffer.readBlockPos());
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeUtf(this.playerName);
        buffer.writeUtf(this.vehicle);
        buffer.writeBlockPos(this.pos);
    }

    public void handle(CustomPayloadEvent.Context context) {
        ServerPlayer player = context.getSender().getServer().getPlayerList().getPlayerByName(this.playerName);

        switch (this.vehicle) {
            case "Carro": {
                break;
            }

            case "Moto": {
                break;
            }
        }

        Entity bike =  new DirtBikeEntity(EntityInit.dirt_bike_entity.get(), context.getSender().level());
        bike.moveTo(pos.getX(), pos.getY() + 1, pos.getZ(), 0, 0);

        context.getSender().level().addFreshEntity(bike);
    }
}

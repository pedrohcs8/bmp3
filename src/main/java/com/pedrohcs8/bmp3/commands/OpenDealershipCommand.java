package com.pedrohcs8.bmp3.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.ClientAccess;
import com.pedrohcs8.bmp3.network.PacketHandler;
import com.pedrohcs8.bmp3.network.bank.money.S2CAddMoney;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Bmp3.MOD_ID)
public class OpenDealershipCommand {
    static int pressTime = 0;
    static boolean runCommand = false;

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("dealership")
                .requires(source -> {
                    return source.hasPermission(2);
                })
                .executes((command) -> {
                    return execute(command);
                }));
    }

    private static int execute(CommandContext<CommandSourceStack> command) {
        if (command.getSource().getEntity() instanceof Player) {
            runCommand = true;
        }

        return Command.SINGLE_SUCCESS;
    }

    @SubscribeEvent
    public static void onTick(TickEvent.PlayerTickEvent event) {
        pressTime++;
        if (pressTime > 3) {
            pressTime = 0;
            if (runCommand) {
                DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientAccess::DealershipOpen);
                runCommand = false;
            }
        }
    }
}

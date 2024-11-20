package com.pedrohcs8.bmp3.commands.npc;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.pedrohcs8.bmp3.network.PacketHandler;
import com.pedrohcs8.bmp3.network.bank.money.S2CAddMoney;
import com.pedrohcs8.bmp3.network.bank.money.S2CRemoveMoney;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class SellItemCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext pContext) {
        dispatcher.register(Commands.literal("sell_item")
                .requires(source -> {
                    return source.hasPermission(2);
                })
                .then(Commands.argument("money", IntegerArgumentType.integer()).then(
                        Commands.argument("player", StringArgumentType.string()).then(
                                Commands.argument("mercadoria", ItemArgument.item(pContext)).then(
                                        Commands.argument("qntd", IntegerArgumentType.integer())
                                        .executes((command) -> {
                                            return execute(command);
                                        })
                                )))));
    }

    private static int execute(CommandContext<CommandSourceStack> command) {
        if (command.getSource().getEntity() instanceof Player) {
            Player sender = (Player) command.getSource().getEntity();
            ServerPlayer target = command.getSource().getServer().getPlayerList().getPlayerByName(StringArgumentType.getString(command, "player"));
            int qntd = IntegerArgumentType.getInteger(command, "qntd");

            PacketHandler.sendToSpecificPlayer(new S2CRemoveMoney(IntegerArgumentType.getInteger(command, "money") * qntd, ItemArgument.getItem(command, "mercadoria").getItem().toString(), qntd), target);
            sender.sendSystemMessage(Component.literal("Sucesso!"));
        }

        return Command.SINGLE_SUCCESS;
    }
}

package com.pedrohcs8.bmp3.commands.npc;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.pedrohcs8.bmp3.network.PacketHandler;
import com.pedrohcs8.bmp3.network.bank.money.S2CAddMoney;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;

public class BuyItemCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext pContext) {
        dispatcher.register(Commands.literal("buy_item")
                .requires(source -> {
                    return source.hasPermission(2);
                })
                .then(Commands.argument("money", IntegerArgumentType.integer()).then(
                        Commands.argument("player", StringArgumentType.string()).then(
                                Commands.argument("mercadoria", ItemArgument.item(pContext))
                                        .executes((command) -> {
                                            return execute(command);
                                        })
                        ))));
    }

    private static int execute(CommandContext<CommandSourceStack> command) {
        if (command.getSource().getEntity() instanceof Player) {
            Player sender = (Player) command.getSource().getEntity();
            ServerPlayer target = command.getSource().getServer().getPlayerList().getPlayerByName(StringArgumentType.getString(command, "player"));

            for (int i = 0; i < target.getInventory().getContainerSize(); i++) {
                Item invItem = target.getInventory().getItem(i).getItem();
                Item selItem = ItemArgument.getItem(command, "mercadoria").getItem();

                if (invItem == selItem) {
                    int amount = target.getInventory().getItem(i).getCount();
                    target.getInventory().removeItem(i, amount);
                    PacketHandler.sendToSpecificPlayer(new S2CAddMoney(IntegerArgumentType.getInteger(command, "money") * amount), target);
                }
            }
            sender.sendSystemMessage(Component.literal("Sucesso!"));
        }

        return Command.SINGLE_SUCCESS;
    }
}

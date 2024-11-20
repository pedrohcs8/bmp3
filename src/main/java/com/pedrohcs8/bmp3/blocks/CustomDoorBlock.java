package com.pedrohcs8.bmp3.blocks;

import com.pedrohcs8.bmp3.init.ModItems;
import com.pedrohcs8.bmp3.items.CustomKeyItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.phys.BlockHitResult;

public class CustomDoorBlock extends DoorBlock {
    private static String playerName = "";

    public CustomDoorBlock() {
        super(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if (pPlayer.getItemInHand(InteractionHand.MAIN_HAND).getItem().equals(ModItems.custom_key.get())) {
            CustomKeyItem item = (CustomKeyItem) pPlayer.getItemInHand(InteractionHand.MAIN_HAND).getItem();

            if (item.getTooltip().startsWith("Chave de")) {
                return InteractionResult.SUCCESS;
            }

            if (playerName == "") {
                playerName = pPlayer.getName().toString();
            }

            item.setFoil(true);
            item.setTooltip("Chave de " + playerName);

            if (playerName.equals(pPlayer.getName().toString())) {
                return super.useWithoutItem(pState, pLevel, pPos, pPlayer, pHitResult);
            }
        }

        return InteractionResult.SUCCESS;
    }
}

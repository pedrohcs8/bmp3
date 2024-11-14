package com.pedrohcs8.bmp3.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class CustomKeyEItem extends Item {
    public CustomKeyEItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}

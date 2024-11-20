package com.pedrohcs8.bmp3.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class CustomKeyItem extends Item {
    private boolean foil = false;
    private String tooltip = "";

    public CustomKeyItem(Properties pProperties) {
        super(pProperties);
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public String getTooltip() {
        return this.tooltip;
    }

    public void setFoil(boolean isFoil) {
        this.foil = isFoil;
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return this.foil;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.literal(this.tooltip));

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}

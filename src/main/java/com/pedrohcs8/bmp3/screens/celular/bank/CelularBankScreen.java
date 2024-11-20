package com.pedrohcs8.bmp3.screens.celular.bank;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.ClientAccess;
import com.pedrohcs8.bmp3.capabilities.Bank.BankMoneyProvider;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

public class CelularBankScreen extends Screen {
    private static final Component title = Component.literal("Celular");

    private static final ResourceLocation bgTexture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/bank/bank_bg.png");
    private static final ResourceLocation returnButtonTexture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/return_button.png");

    private static final ResourceLocation cobrarButtonTexture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/bank/cobrar_button.png");
    private static final ResourceLocation pagarButtonTexture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/bank/pagar_button.png");

    private final int imageWidth, imageHeight;
    private int leftPos, topPos;

    int playerMoney = 0;

    private Button returnButton;
    private Button cobrarButton;
    private Button pagarButton;

    public CelularBankScreen() {
        super(title);


        this.imageWidth = 140;
        this.imageHeight = 186;
    }

    @Override
    protected void init() {
        super.init();

        if (this.minecraft == null) {
            return;
        }

        Level level = this.minecraft.level;
        if (level == null) {
            return;
        }

        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;

        this.minecraft.player.getCapability(BankMoneyProvider.bank_money).ifPresent(money -> {
            this.playerMoney = money.getMoney();
        });

        this.returnButton = this.addRenderableWidget(Button.builder(Component.literal(""), this::handleReturnButton)
                .bounds(this.leftPos + 64, this.topPos + 170, 12, 12)
                .tooltip(Tooltip.create(Component.literal("Retornar")))
                .build());

        this.pagarButton = this.addRenderableWidget(Button.builder(Component.literal(""), this::handlePayButton)
                .bounds(this.leftPos + 7, this.topPos + 85, 24, 24)
                .tooltip(Tooltip.create(Component.literal("Pagar")))
                .build());

        this.cobrarButton = this.addRenderableWidget(Button.builder(Component.literal(""), this::handleCobrarButton)
                .bounds(this.leftPos + 36, this.topPos + 85, 24, 24)
                .tooltip(Tooltip.create(Component.literal("Cobrar")))
                .build());
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        pGuiGraphics.blit(bgTexture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        pGuiGraphics.blit(returnButtonTexture, this.leftPos + 64, this.topPos + 170, 0, 0, 12, 12);

        pGuiGraphics.blit(pagarButtonTexture, this.leftPos + 7, this.topPos + 85, 0, 0, 24, 24);
        pGuiGraphics.blit(cobrarButtonTexture, this.leftPos + 36, this.topPos + 85, 0, 0, 24, 24);

        pGuiGraphics.drawString(this.minecraft.font, this.minecraft.getUser().getName(),this.leftPos + 5, this.topPos + 40, 0xFFFFF);
        pGuiGraphics.drawString(this.minecraft.font, Integer.toString(this.playerMoney),this.leftPos + 30, this.topPos + 63, 0xFFFFF);
    }

    @Override
    public void renderBackground(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
//        super.renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    private void handleReturnButton(Button button) {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientAccess::CelularMainScreenOpen);
    }

    private void handlePayButton(Button button) {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientAccess::CelularPayOpen);
    }

    private void handleCobrarButton(Button button) {

    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}

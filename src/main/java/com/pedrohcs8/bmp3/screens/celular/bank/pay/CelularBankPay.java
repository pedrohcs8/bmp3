package com.pedrohcs8.bmp3.screens.celular.bank.pay;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.ClientAccess;
import com.pedrohcs8.bmp3.capabilities.Bank.BankMoneyProvider;
import com.pedrohcs8.bmp3.network.PacketHandler;
import com.pedrohcs8.bmp3.network.bank.pay.C2SPay;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

public class CelularBankPay extends Screen {
    private static final Component title = Component.literal("Celular");

    private static final ResourceLocation bgTexture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/celular_main_bg_blank.png");
    private static final ResourceLocation returnButtonTexture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/return_button.png");

    private final int imageWidth, imageHeight;
    private int leftPos, topPos;

    private Button returnButton;
    private EditBox nameBox;
    private EditBox moneyBox;
    private Button payButton;

    public CelularBankPay() {
        super(title);
        // TODO: HANDLE 0 MONEY

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

        this.returnButton = this.addRenderableWidget(Button.builder(Component.literal(""), this::handleReturnButton)
                .bounds(this.leftPos + 63, this.topPos + 170, 12, 12)
                .tooltip(Tooltip.create(Component.literal("Retornar")))
                .build());

        this.nameBox = this.addRenderableWidget(new EditBox(this.minecraft.font, this.leftPos + 12, this.topPos + 31,116, 18, Component.literal("Nome do Player")));
        this.moneyBox = this.addRenderableWidget(new EditBox(this.minecraft.font, this.leftPos + 12, this.topPos + 71,116, 18, Component.literal("Nome do Player")));

        this.payButton = this.addRenderableWidget(Button.builder(Component.literal("Confirmar Pagamento"), this::handlePayButton)
                .bounds(this.leftPos + 12, this.topPos + 150, 116, 12)
                .tooltip(Tooltip.create(Component.literal("Confirmar Pagamento")))
                .build());
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        pGuiGraphics.blit(bgTexture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        pGuiGraphics.blit(returnButtonTexture, this.leftPos + 64, this.topPos + 170, 0, 0, 12, 12);
        pGuiGraphics.drawString(this.minecraft.font, "Nome do Player", this.leftPos + 12, this.topPos + 21, 0xFFFFF);
        pGuiGraphics.drawString(this.minecraft.font, "Quantidade", this.leftPos + 12, this.topPos + 61, 0xFFFFF);
    }

    @Override
    public void renderBackground(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
//        super.renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    private void handleReturnButton(Button button) {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientAccess::CelularBankOpen);
    }

    private void handlePayButton(Button button) {
        this.minecraft.player.getCapability(BankMoneyProvider.bank_money).ifPresent(money -> {
            money.removeMoney(Integer.parseInt(moneyBox.getValue()));
        });

        PacketHandler.sendToServer(new C2SPay(nameBox.getValue(), Integer.parseInt(moneyBox.getValue())));
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}

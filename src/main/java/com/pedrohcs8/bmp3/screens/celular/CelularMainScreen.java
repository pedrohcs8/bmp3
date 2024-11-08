package com.pedrohcs8.bmp3.screens.celular;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.ClientAccess;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.*;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

public class CelularMainScreen extends Screen {
    private static final Component title = Component.literal("Celular");

    private static final ResourceLocation bgTexture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/celular_main_bg.png");
    private static final ResourceLocation returnButtonTexture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/return_button.png");
    private static final ResourceLocation whatsAppButtonTexture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/whatsapp/whatsapp_button.png");

    private final int imageWidth, imageHeight;
    private int leftPos, topPos;

    private Button whatsappButton;
    private Button returnButton;

    public CelularMainScreen() {
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

        this.whatsappButton = this.addRenderableWidget(
                Button.builder(Component.literal(""), this::handleButton)
                        .bounds(this.leftPos + 11, this.topPos + 12, 32, 32)
                        .tooltip(Tooltip.create(Component.literal("WhatsApp")))
                        .build()
        );


        this.returnButton = this.addRenderableWidget(Button.builder(Component.literal(""), this::handleReturnButton)
                .bounds(this.leftPos + 63, this.topPos + 170, 12, 12)
                .tooltip(Tooltip.create(Component.literal("Retornar")))
                .build());
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        pGuiGraphics.blit(bgTexture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        pGuiGraphics.blit(returnButtonTexture, this.leftPos + 63, this.topPos + 170, 0, 0, 12, 12);
        pGuiGraphics.blit(whatsAppButtonTexture, this.leftPos + 11, this.topPos + 12, 0, 0, 32, 32);

    }

    @Override
    public void renderBackground(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
//        super.renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    private void handleButton(Button button) {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientAccess::CelularWhatsappOpen);
    }

    private void handleReturnButton(Button button) {

    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}

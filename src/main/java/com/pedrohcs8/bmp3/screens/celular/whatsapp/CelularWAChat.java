package com.pedrohcs8.bmp3.screens.celular.whatsapp;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.ClientAccess;
import com.pedrohcs8.bmp3.Utils;
import com.pedrohcs8.bmp3.network.C2SMessageSend;
import com.pedrohcs8.bmp3.network.PacketHandler;
import net.minecraft.Util;
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
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.List;

public class CelularWAChat extends Screen {
    private static final Component title = Component.literal("Celular");

    private static final ResourceLocation bgTexture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/celular_main_bg_blank.png");
    private static final ResourceLocation returnButtonTexture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/return_button.png");
    private static final ResourceLocation sendMessageButtonTexture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/whatsapp/whatsapp_send_message.png");

    private final int imageWidth, imageHeight;
    private int leftPos, topPos;
    private String playerName;

    private Button returnButton;
    private Button sendMessageButton;
    private EditBox messageBox;

    public CelularWAChat(String playerName) {
        super(title);


        this.imageWidth = 140;
        this.imageHeight = 186;
        this.playerName = playerName;
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

        this.sendMessageButton = this.addRenderableWidget(Button.builder(Component.literal(""), this::handleSendMsgButton)
                .bounds(this.leftPos + 120, this.topPos + 152, 12, 12)
                .tooltip(Tooltip.create(Component.literal("Mandar Mensagem")))
                .build());

        this.messageBox = this.addRenderableWidget(new EditBox(this.minecraft.font, this.leftPos + 10, this.topPos + 150,105, 15, Component.literal("Mensagem")));
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        pGuiGraphics.blit(bgTexture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);

        pGuiGraphics.blit(returnButtonTexture, this.leftPos + 64, this.topPos + 170, 0, 0, 12, 12);
        pGuiGraphics.blit(sendMessageButtonTexture, this.leftPos + 120, this.topPos + 152, 0, 0, 12, 12);
        pGuiGraphics.drawString(this.minecraft.font, playerName, this.leftPos + 60, this.topPos + 10, 0xFFFFF);

        List<String> messages = Utils.readMessageFile(playerName);

        int heightMessageOffset = 40;

        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).isEmpty()) {
                continue;
            }

            String message = messages.get(i).split(",")[0];
            String author = messages.get(i).split(",")[1];

            pGuiGraphics.drawString(this.minecraft.font, author, this.leftPos + 20, this.topPos + heightMessageOffset, 0xFFFFF);
            pGuiGraphics.drawString(this.minecraft.font, message, this.leftPos + 60, this.topPos + heightMessageOffset, 0xFFFFF);

            heightMessageOffset = heightMessageOffset + 13;
        }
    }

    @Override
    public void renderBackground(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
//        super.renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    private void handleSendMsgButton(Button button) {
        PacketHandler.sendToServer(new C2SMessageSend(messageBox.getValue(), this.playerName, this.minecraft.getUser().getName()));

        Utils.createMessageFile(playerName);
        Utils.writeToMsgFile(playerName, this.minecraft.getUser().getName(), messageBox.getValue());
    }

    private void handleReturnButton(Button button) {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientAccess::CelularWhatsappOpen);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

}
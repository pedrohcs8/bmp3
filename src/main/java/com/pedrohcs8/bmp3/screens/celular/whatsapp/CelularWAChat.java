package com.pedrohcs8.bmp3.screens.celular.whatsapp;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.ClientAccess;
import com.pedrohcs8.bmp3.Utils;
import com.pedrohcs8.bmp3.network.whatsapp.C2SMessageSend;
import com.pedrohcs8.bmp3.network.PacketHandler;
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

import java.util.List;

public class CelularWAChat extends Screen {
    private static final Component title = Component.literal("Celular");

    private static final ResourceLocation bgTexture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/celular_main_bg_blank.png");
    private static final ResourceLocation returnButtonTexture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/return_button.png");
    private static final ResourceLocation sendMessageButtonTexture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/whatsapp/whatsapp_send_message.png");

    private final int imageWidth, imageHeight;
    private int leftPos, topPos;
    private String playerName;

    private int messageSize = 0;
    private int currentIndex = 0;

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

        List<String> messages = Utils.readMessageFile(playerName);

        this.messageSize = messages.size();

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

        // ImageWidth / 2 - PlayerLength / 2 - Offset
        int playerTitleOffset = (imageWidth / 2) - (playerName.length() * 3);

        pGuiGraphics.blit(returnButtonTexture, this.leftPos + 64, this.topPos + 170, 0, 0, 12, 12);
        pGuiGraphics.blit(sendMessageButtonTexture, this.leftPos + 120, this.topPos + 152, 0, 0, 12, 12);
        pGuiGraphics.drawString(this.minecraft.font, playerName, this.leftPos + playerTitleOffset, this.topPos + 10, 0xFFFFF);

        List<String> messages = Utils.readMessageFile(playerName);
        this.messageSize = messages.size();

        int heightMessageOffset = 40;

        for (int i = currentIndex; i < messageSize; i++) {
            if (messages.get(i).isEmpty()) {
                continue;
            }

            if (i > (5 + currentIndex)) {
                continue;
            }

            String message = messages.get(i).split(",")[0];
            String author = messages.get(i).split(",")[1];

            // (Author length * X) + offset
            int authorOffset = (author.length() * 6) + 25;

            pGuiGraphics.drawString(this.minecraft.font, author + ":", this.leftPos + 20, this.topPos + heightMessageOffset, 0xFFFFF);
            pGuiGraphics.drawString(this.minecraft.font, message, this.leftPos + authorOffset, this.topPos + heightMessageOffset, 0xFFFFF);

            heightMessageOffset = heightMessageOffset + 13;
        }
    }

    @Override
    public boolean mouseScrolled(double pMouseX, double pMouseY, double pScrollX, double pScrollY) {
        switch ((int) pScrollY) {
            case 1: {
                if (currentIndex > 0) {
                    currentIndex = currentIndex - 1;
                }
                break;
            }

            case -1: {
                if (currentIndex < messageSize) {
                    currentIndex = currentIndex + 1;
                }
                break;
            }
        }

        return super.mouseScrolled(pMouseX, pMouseY, pScrollX, pScrollY);
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

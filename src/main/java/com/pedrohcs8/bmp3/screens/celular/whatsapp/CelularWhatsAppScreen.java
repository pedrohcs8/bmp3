package com.pedrohcs8.bmp3.screens.celular.whatsapp;

import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.ClientAccess;
import com.pedrohcs8.bmp3.capabilities.Whatsapp.WAAddedPlayersProvider;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

import java.util.ArrayList;
import java.util.List;

public class CelularWhatsAppScreen extends Screen {
    private static final Component title = Component.literal("Celular");
    private int maxContacts = 5;

    private static final ResourceLocation bgTexture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/whatsapp/whatsapp_contacts_page.png");
    private static final ResourceLocation returnButtonTexture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/return_button.png");
    private static final ResourceLocation configButtonTexture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/whatsapp/whatsapp_config_button.png");
    private static final ResourceLocation contactCard = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/whatsapp/whatsapp_contact.png");

    private final int imageWidth, imageHeight;
    private int leftPos, topPos;

    private Button returnButton;
    private Button configButton;

    private static List<Button> contactButtons = new ArrayList<>();
    private static  List<String> contactNames = new ArrayList<>();

    public CelularWhatsAppScreen() {
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

        this.returnButton = this.addRenderableWidget(Button.builder(Component.literal(""), this::handleReturnButton)
                .bounds(this.leftPos + 63, this.topPos + 170, 12, 12)
                .tooltip(Tooltip.create(Component.literal("Retornar")))
                .build());

        this.configButton = this.addRenderableWidget(Button.builder(Component.literal(""), this::handleConfigButton)
                .bounds(this.leftPos + 118, this.topPos + 11, 12, 12)
                .tooltip(Tooltip.create(Component.literal("Configurações")))
                .build());

        this.minecraft.player.getCapability(WAAddedPlayersProvider.player_contatos).ifPresent(contatos -> {
            List<String> allContatos = contatos.getAddedPlayers();
            int heightOffset = 40;

            if (allContatos != null && !allContatos.isEmpty()) {
                for (int i = 0; i < allContatos.size(); i++) {
                    if (!allContatos.get(i).isEmpty()) {
                        contactButtons.add(this.addRenderableWidget(Button.builder(Component.literal(""), this::handleContactButton)
                                .bounds(this.leftPos + 15, this.topPos + heightOffset, 116, 26)
                                .tooltip(Tooltip.create(Component.literal(allContatos.get(i))))
                                .build()));

                        contactNames.add(allContatos.get(i));
                        heightOffset = heightOffset + 30;
                    }
                }
            }
        });
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        pGuiGraphics.blit(bgTexture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);

        pGuiGraphics.blit(returnButtonTexture, this.leftPos + 64, this.topPos + 170, 0, 0, 12, 12);
        pGuiGraphics.blit(configButtonTexture, this.leftPos + 118, this.topPos + 11, 0, 0, 10, 10);

        this.minecraft.player.getCapability(WAAddedPlayersProvider.player_contatos).ifPresent(contatos -> {
            List<String> allContatos = contatos.getAddedPlayers();
            int heightOffset = 40;
            int stringHOffset = 50;

            if (allContatos != null && !allContatos.isEmpty()) {
                for (int i = 0; i < allContatos.size(); i++) {
                    if (!allContatos.get(i).isEmpty()) {
                        pGuiGraphics.blit(contactCard, this.leftPos + 15, this.topPos + heightOffset, 0, 0, 116, 26);
                        pGuiGraphics.drawString(this.minecraft.font, allContatos.get(i), this.leftPos + 48, this.topPos + stringHOffset, 0xFFFFF);

                        heightOffset = heightOffset + 30;
                        stringHOffset = stringHOffset + 30;
                    }
                }
            }
        });
    }

    @Override
    public void renderBackground(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
//        super.renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    private void handleReturnButton(Button button) {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientAccess::CelularMainScreenOpen);
    }

    private void handleConfigButton(Button button) {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientAccess::CelularWAConfigOpen);
    }

    private void handleContactButton(Button button) {
        int buttonIndex = -1;

        for (int i = 0; i < contactButtons.size(); i++) {
            if (contactButtons.get(i).getTooltip() == button.getTooltip()) {
                buttonIndex = i;
                break;
            }
        }

        if (buttonIndex == -1) {
            return;
        }

        String playerName = contactNames.get(buttonIndex);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ClientAccess.CelularWAChatOpen(playerName));
    }


    @Override
    public boolean isPauseScreen() {
        return false;
    }
}

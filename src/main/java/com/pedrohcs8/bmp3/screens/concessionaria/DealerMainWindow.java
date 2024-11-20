package com.pedrohcs8.bmp3.screens.concessionaria;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.pedrohcs8.bmp3.Bmp3;
import com.pedrohcs8.bmp3.ClientAccess;
import com.pedrohcs8.bmp3.capabilities.Bank.BankMoneyProvider;
import com.pedrohcs8.bmp3.capabilities.Dealer.VehicleCapabilityProvider;
import com.pedrohcs8.bmp3.capabilities.Dealer.VehiclesCapability;
import com.pedrohcs8.bmp3.network.PacketHandler;
import com.pedrohcs8.bmp3.network.bank.money.C2SRemoveMoney;
import com.pedrohcs8.bmp3.network.bank.money.S2CRemoveMoney;
import com.pedrohcs8.bmp3.network.dealer.C2SSpawnVehicle;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

public class DealerMainWindow extends Screen {
    private static final Component title = Component.literal("Concessionaria");

    private static final ResourceLocation bgTexture = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/dealer/dealer_main_screen.png");
    private static final ResourceLocation vehicleNameFill = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/dealer/vehicle_name_bar.png");

    private static final ResourceLocation carPreview = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/dealer/previews/car_preview.png");
    private static final ResourceLocation motoPreview = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/dealer/previews/moto_preview.png");

    private static final ResourceLocation buyVehicle = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/dealer/buy_vehicle_button.png");
    private static final ResourceLocation spawnVehicle = ResourceLocation.fromNamespaceAndPath(Bmp3.MOD_ID, "textures/gui/dealer/spawn_vehicle_button.png");

    private final int imageWidth, imageHeight;
    private int leftPos, topPos;

    private Button carroButton;
    private Button motoButton;

    private Button buyButton;
    private Button spawnButton;

    private String renderVehicle = "";
    private boolean spawned_moto = false;
    private boolean spawned_carro = false;

    public DealerMainWindow() {
        super(title);

        this.imageWidth = 79;
        this.imageHeight = 245;
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

        this.carroButton = this.addRenderableWidget(
                Button.builder(Component.literal(""), this::handleCarroButton)
                        .bounds(9, 11, 64, 5)
                        .tooltip(Tooltip.create(Component.literal("Carro")))
                        .build()
                );

        this.motoButton = this.addRenderableWidget(
                Button.builder(Component.literal(""), this::handleMotoButton)
                        .bounds(9, 22, 64, 5)
                        .tooltip(Tooltip.create(Component.literal("Moto")))
                        .build()
        );

        this.buyButton = this.addRenderableWidget(
                Button.builder(Component.literal(""), this::handleBuyButton)
                        .bounds(97, 160, 128, 32)
                        .tooltip(Tooltip.create(Component.literal("Comprar Veiculo")))
                        .build()
        );

        this.spawnButton = this.addRenderableWidget(
                Button.builder(Component.literal(""), this::handleSpawnButton)
                        .bounds(97, 200, 128, 32)
                        .tooltip(Tooltip.create(Component.literal("Spawnar Veiculo")))
                        .build()
        );
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        pGuiGraphics.blit(bgTexture, 0, 0, 0, 0, this.imageWidth, this.imageHeight);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);

        pGuiGraphics.blit(vehicleNameFill, 9, 11, 0, 0, 64, 5);
        pGuiGraphics.blit(vehicleNameFill, 9, 22, 0, 0, 64, 5);

        pGuiGraphics.drawString(this.minecraft.font, "Carro", 9, 11, 0xFFFFF);
        pGuiGraphics.drawString(this.minecraft.font, "Moto", 9, 22, 0xFFFFF);

        switch(renderVehicle) {
            case "Carro": {
                pGuiGraphics.blit(carPreview, 160, 25, 0, 0, 140, 120);
                break;
            }

            case "Moto": {
                pGuiGraphics.blit(motoPreview, 160, 25, 0, 0, 140, 120);
                break;
            }

            default: {
                break;
            }
        }

        pGuiGraphics.blit(buyVehicle, 97, 160, 0, 0, 128, 32);
        pGuiGraphics.blit(spawnVehicle, 97, 200, 0, 0, 128, 31);
    }

    @Override
    public void renderBackground(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
//        super.renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    private void handleCarroButton(Button button) {
        renderVehicle = "Carro";
    }

    private void handleMotoButton(Button button) {
        renderVehicle = "Moto";
    }

    private void handleBuyButton(Button button) {
        String playerName = this.minecraft.getUser().getName();
        BlockPos pos = this.minecraft.player.getOnPos();
        LocalPlayer player = this.minecraft.player;

        switch (renderVehicle) {
            case "Carro": {
                this.minecraft.player.getCapability(BankMoneyProvider.bank_money).ifPresent(money -> {
                    if (money.getMoney() >= 25000) {
                        money.removeMoney(25000);
                        PacketHandler.sendToServer(new C2SSpawnVehicle(playerName, "Carro", pos));
                        spawned_carro = true;
                    } else {
                        player.sendSystemMessage(Component.literal("Você não tem dinheiro para esta operação"));
                    }
                });

                break;
            }

            case "Moto": {
                player.getCapability(BankMoneyProvider.bank_money).ifPresent(money -> {
                    if (money.getMoney() >= 15000) {
                        player.getCapability(VehicleCapabilityProvider.player_vehicles).ifPresent(vehicle -> {
                            if (!vehicle.isIncluded("Moto")) {
                                vehicle.addVehicle("Moto");
                                money.removeMoney(15000);
                                PacketHandler.sendToServer(new C2SSpawnVehicle(playerName, "Moto", pos));
                                spawned_moto = true;
                            } else {
                                player.sendSystemMessage(Component.literal("Você já possui este veículo, spawne ele com o botão spawnar"));
                            }
                        });
                    } else {
                        player.sendSystemMessage(Component.literal("Você não tem dinheiro para esta operação"));
                    }
                });

                break;
            }
        }
    }

    private void handleSpawnButton(Button button) {
        String playerName = this.minecraft.getUser().getName();
        BlockPos pos = this.minecraft.player.getOnPos();
        LocalPlayer player = this.minecraft.player;

        switch (renderVehicle) {
            case "Carro": {
                if (!spawned_carro) {
                    player.getCapability(VehicleCapabilityProvider.player_vehicles).ifPresent(vehicle -> {
                        if (vehicle.isIncluded("Moto")) {
                            PacketHandler.sendToServer(new C2SSpawnVehicle(playerName, "Carro", pos));
                            spawned_carro = true;
                        } else {
                            player.sendSystemMessage(Component.literal("Você não possui este veículo"));
                        }
                    });
                }
            }

            case "Moto": {
                player.getCapability(VehicleCapabilityProvider.player_vehicles).ifPresent(vehicle -> {
                    if (!spawned_moto) {
                        if (vehicle.isIncluded("Moto")) {
                            PacketHandler.sendToServer(new C2SSpawnVehicle(playerName, "Carro", pos));
                            spawned_moto = true;
                        } else {
                            player.sendSystemMessage(Component.literal("Você não possui este veículo"));
                        }
                    }
                });
            }
        }
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}

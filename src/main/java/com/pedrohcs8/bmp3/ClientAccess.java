package com.pedrohcs8.bmp3;

import com.pedrohcs8.bmp3.screens.celular.CelularMainScreen;
import com.pedrohcs8.bmp3.screens.celular.bank.CelularBankScreen;
import com.pedrohcs8.bmp3.screens.celular.bank.pay.CelularBankPay;
import com.pedrohcs8.bmp3.screens.celular.whatsapp.CelularWAAddPlayer;
import com.pedrohcs8.bmp3.screens.celular.whatsapp.CelularWAChat;
import com.pedrohcs8.bmp3.screens.celular.whatsapp.CelularWAConfigScreen;
import com.pedrohcs8.bmp3.screens.celular.whatsapp.CelularWhatsAppScreen;
import net.minecraft.client.Minecraft;

public class ClientAccess {

    // Whatsapp
    public static void CelularMainScreenOpen() {
        Minecraft.getInstance().setScreen(new CelularMainScreen());
    }

    public static void CelularWhatsappOpen() {
        Minecraft.getInstance().setScreen(new CelularWhatsAppScreen());
    }

    public static void CelularWAConfigOpen() {
        Minecraft.getInstance().setScreen(new CelularWAConfigScreen());
    }

    public static void CelularWAAddPlayerOpen() {
        Minecraft.getInstance().setScreen(new CelularWAAddPlayer());
    }

    public static void CelularWAChatOpen(String playerName) {
        Minecraft.getInstance().setScreen(new CelularWAChat(playerName));
    }

    // Bank

    public static void CelularBankOpen() {
        Minecraft.getInstance().setScreen(new CelularBankScreen());
    }

    public static void CelularPayOpen() {
        Minecraft.getInstance().setScreen(new CelularBankPay());
    }
}

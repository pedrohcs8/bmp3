package com.pedrohcs8.bmp3;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static void saveImg(String FILE_URL, String path) throws IOException {
        InputStream in = new URL(FILE_URL).openStream();
        Files.copy(in, Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void DownloadSkinHead(String username) {
        if (Files.notExists(Paths.get(System.getProperty("user.dir") + "/bmp3"))) {
            try {
                Files.createDirectory(Paths.get(System.getProperty("user.dir") + "/bmp3"));
                Files.createDirectory(Paths.get(System.getProperty("user.dir") + "/bmp3/skins"));
                Files.createDirectory(Paths.get(System.getProperty("user.dir") + "/bmp3/messages"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (Files.notExists(Paths.get(System.getProperty("user.dir") + "/bmp3/skins/" + username + ".png"))) {
            try {
                Utils.saveImg("https://mc-heads.net/avatar/" + username, System.getProperty("user.dir") + "/bmp3/skins/" + username + ".png");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void createMessageFile(String playerName) {
        if (Files.notExists(Paths.get(System.getProperty("user.dir") + "/bmp3"))) {
            try {
                Files.createDirectory(Paths.get(System.getProperty("user.dir") + "/bmp3"));
                Files.createDirectory(Paths.get(System.getProperty("user.dir") + "/bmp3/skins"));
                Files.createDirectory(Paths.get(System.getProperty("user.dir") + "/bmp3/messages"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            File messageFile = new File(System.getProperty("user.dir") + "/bmp3/messages/" + playerName + ".txt");
            messageFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToMsgFile(String playerName, String author, String message) {
        try {
            if (Files.notExists(Paths.get(System.getProperty("user.dir") + "/bmp3/messages/" + playerName + ".txt")) || FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/bmp3/messages/" + playerName + ".txt")).trim().isEmpty()) {
                FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/bmp3/messages/" + playerName + ".txt");
                writer.write(message + "," + author);
                writer.close();
            } else {
                BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/bmp3/messages/" + playerName + ".txt", true));
                writer.newLine();
                writer.append(message + "," + author);
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readMessageFile(String playerName) {
        if (Files.notExists(Paths.get(System.getProperty("user.dir") + "/bmp3/messages/" + playerName + ".txt"))) {
            return new ArrayList<>();
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/bmp3/messages/" + playerName + ".txt"));
            return reader.lines().toList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}

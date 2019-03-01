package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PaperCalculator {
    public static void main(String[] args) throws Exception {
        System.out.println("Rozpoczynam pobieranie wymiarow skrzynek...");
        final URL oracle = new URL("https://raw.githubusercontent.com/SamouczekProgramisty/StrefaZadaniowaSamouka/master/test_input.txt");
        final BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        final List<Box> boxes = receiveBoxes(in);
        final int result = boxes.stream().mapToInt(Box::getRequiredPaper).sum();
        System.out.println(String.format("Do opakowania wszystkich wczytanych paczek potrzebujesz %d dm2 papieru.", result));
    }

    private static List<Box> receiveBoxes(BufferedReader in) throws IOException {
        final List<Box> boxes = new ArrayList<>();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            boxes.add(new Box(inputLine));
        }
        in.close();
        System.out.println(String.format("Zakończono. Pobrałem %d skrzynek.", boxes.size()));
        return boxes;
    }
}

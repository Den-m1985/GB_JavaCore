package org.example.ticTacToe;

import java.io.*;

public class ReadGameFile {

    public int[][] readGameFile(String filePath) {
        int[][] gameField = new int[3][3];
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.trim().split(" ");
                for (int i = 0; i < numbers.length; i++) {
                    gameField[row][i] = Integer.parseInt(numbers[i]);
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gameField;
    }

}

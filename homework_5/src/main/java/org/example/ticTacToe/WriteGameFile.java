package org.example.ticTacToe;

import java.io.*;

public class WriteGameFile {
    public WriteGameFile(int[][] gameField, String filePath) {

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            // Проходим по всем строкам двумерного массива
            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < gameField[i].length; j++) {
                    // Преобразуем элемент в байт и записываем его в файл
                    byte [] byteNumber = String.valueOf(gameField[i][j]).getBytes();
                    fos.write(byteNumber);
                    fos.write(" ".getBytes()); // Разделяем элементы пробелом
                }
                fos.write(System.lineSeparator().getBytes()); // Переходим на новую строку
            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

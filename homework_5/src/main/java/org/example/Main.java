package org.example;

import org.example.ticTacToe.PrintGame;
import org.example.ticTacToe.ReadGameFile;
import org.example.ticTacToe.WriteGameFile;


public class Main {
    public static void main(String[] args) {

        // Задание 1
        new BackupFiles();


        // Задание 2
        int[][] gameField = {
                {1, 2, 0},
                {0, 1, 0},
                {2, 0, 2}
        };

        String filePath = "gameField.txt";

        // Запись игрового поля в файл
        new WriteGameFile(gameField, filePath);

        // Чтение игрового поля из файла
        int[][] importedGameField = new ReadGameFile().readGameFile(filePath);

        // Вывод игрового поля в консоль
        new PrintGame(importedGameField);

    }

}
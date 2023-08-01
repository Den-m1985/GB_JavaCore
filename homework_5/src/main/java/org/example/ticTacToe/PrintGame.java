package org.example.ticTacToe;

public class PrintGame {
    public PrintGame(int[][] gameField) {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                switch (gameField[i][j]) {
                    case 1:
                        System.out.print("X ");
                        break;
                    case 2:
                        System.out.print("O ");
                        break;
                    default:
                        System.out.print("• ");
                        break;
                }
            }
            System.out.println();
        }
    }

}

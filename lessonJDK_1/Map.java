import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;

public class Map extends JPanel {
    private static final Random RANDOM = new Random();
    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int EMPTY_DOT = 0;
    private static final int DOT_PADDING = 5;

    private int gameStateType;
    private static final int STATE_GAME = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;
    private static final int STATE_DRAW = 3;

    private static final String MSG_WIN_HUMAN = "Human win";
    private static final String MSG_WIN_AI = "Ai win";
    private static final String MSG_DRAW = "Draw";

    private int panelWidth, panelHeight, cellHeight, cellWigth;
    private int mode, fieldSizeX, fieldSizeY, winLen;
    private int[][] field;
    private boolean gameWork;


    public Map() {
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (gameWork)
                    update(e);
            }
        });
    }


    private void initMap() {
        field = new int[fieldSizeY][fieldSizeX];
    }


    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        this.mode = mode;
        this.fieldSizeX = fSzX;
        this.fieldSizeY = fSzY;
        this.winLen = wLen;
//        System.out.printf("Mode: %d;\nSize: x=%d, y=%d;\nWin Length: %d",
//                mode, fSzX, fSzY, wLen);
        initMap();
        gameWork = true;
        gameStateType = STATE_GAME;
        repaint();
    }


    private void update(MouseEvent e) {
        int cellX = e.getX() / cellWigth;
        int cellY = e.getY() / cellHeight;
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellY][cellX] = HUMAN_DOT;
        //System.out.printf("x=%d, y=%d\n", cellX, cellY);
        if (checkEndGame(HUMAN_DOT, STATE_WIN_HUMAN)) return;
        aiTurn();
        repaint();
        checkEndGame(AI_DOT, STATE_WIN_AI);
    }


    private void testBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(field[i]));
        }
        System.out.println();
    }


    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }


    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }


    private void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = AI_DOT;
    }


    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }


    private boolean checkEndGame(int dot, int gameOverType) {
        if (checkWin(dot)) {
            this.gameStateType = gameOverType;
            repaint();
            return true;
        } else if (isMapFull()) {
            this.gameStateType = STATE_DRAW;
            repaint();
            return true;
        }
        return false;
    }


    private boolean checkWin(int c) {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (checkLine(i, j, 1, 0, winLen, c)) return true;
                if (checkLine(i, j, 1, 1, winLen, c)) return true;
                if (checkLine(i, j, 0, 1, winLen, c)) return true;
                if (checkLine(i, j, 1, -1, winLen, c)) return true;
            }
        }
        return false;
    }


    private boolean checkLine(int x, int y, int vx, int vy, int len, int dot) {
        int far_x = x + (len - 1) * vx;
        int far_y = y + (len - 1) * vy;
        if (!isValidCell(far_x, far_y)) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (field[y + i * vy][x + i * vx] != dot) {
                return false;
            }
        }
        return true;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameWork)
            render(g);
    }


    private void render(Graphics g) {
        panelWidth = getWidth();
        panelHeight = getHeight();
        cellWigth = panelWidth / fieldSizeX;
        cellHeight = panelHeight / fieldSizeY;

        g.setColor(Color.BLACK);
        for (int h = 0; h < fieldSizeX; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int w = 0; w < fieldSizeY; w++) {
            int x = w * cellWigth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == EMPTY_DOT) continue;
                if (field[y][x] == HUMAN_DOT) {
                    g.drawLine(x * cellWigth + DOT_PADDING, y * cellHeight + DOT_PADDING,
                            (x + 1) * cellWigth - DOT_PADDING, (y + 1) * cellHeight - DOT_PADDING);
                    g.drawLine(x * cellWigth + DOT_PADDING, (y + 1) * cellHeight - DOT_PADDING,
                            (x + 1) * cellWigth - DOT_PADDING, y * cellHeight + DOT_PADDING);
                } else if (field[y][x] == AI_DOT) {
                    g.drawOval(x * cellWigth + DOT_PADDING, y * cellHeight + DOT_PADDING,
                            cellWigth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2);
                } else {
                    throw new RuntimeException("unchecked value " + field[y][x] +
                            " in cell: x=" + x + " y=" + y);
                }
            }
        }
        if (gameStateType != STATE_GAME) showMessageGameOver(g);
    }


    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, getHeight() / 2, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 48));
        switch (gameStateType) {
            case STATE_DRAW -> g.drawString(MSG_DRAW, 180, getHeight() / 2 + 60);
            case STATE_WIN_AI -> g.drawString(MSG_WIN_AI, 70, getHeight() / 2+60);
            case STATE_WIN_HUMAN -> g.drawString(MSG_WIN_HUMAN, 20, getHeight() / 2+60);
            default -> throw new RuntimeException("Unexpected gameOver state: " + gameStateType);
        }
        gameWork = false;
    }

}

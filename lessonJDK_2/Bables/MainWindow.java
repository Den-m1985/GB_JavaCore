package Bables;

import common.CanvasRepaintListener;
import common.Interactable;
import common.MainCanvas;
import common.MouseListeners;
import exeptions.BallsOverflowException;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MainWindow extends JFrame implements CanvasRepaintListener, Thread.UncaughtExceptionHandler {
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    public String nameWindow = "Circles";
    private Interactable[] sprites;
    private final Background background = new Background();
    private static final Random rnd = new Random();
    private static final int MAX_COUNT_SPRITES = 100;
    private static final int START_COUNT_SPRITES = MAX_COUNT_SPRITES - 5;
    int countSprites;


    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(nameWindow);

        ScreenLocator();
        initSprites();

        add(new MainCanvas(this));
        addMouseListener(new MouseListeners(this));

        setVisible(true);
    }

    private void initSprites() {
        sprites = new Interactable[MAX_COUNT_SPRITES];
        sprites[0] = background;
        countSprites = 1;
        for (int i = 0; i < START_COUNT_SPRITES; i++) {
            addSprite(rnd.nextInt(WINDOW_WIDTH), rnd.nextInt(WINDOW_HEIGHT));
        }
    }

    public void addSprite(int x, int y) {
        if (countSprites >= MAX_COUNT_SPRITES) {
            printWindowError();
            throw new BallsOverflowException();
        }
        sprites[countSprites] = new Ball(x, y);
        countSprites++;
    }

    private void printWindowError() {
        JOptionPane.showMessageDialog(null, "Невозможно создать более " + MAX_COUNT_SPRITES + " шаров");
    }

    public void removeSprite() {
        if (countSprites <= 1) {
            return;
        }
        countSprites--;
    }

    private void ScreenLocator() {
        int screenWidth = getToolkit().getScreenSize().width;
        int screenHeight = getToolkit().getScreenSize().height;
        // find coordinate window to set
        int x = (screenWidth - getWidth()) / 2;
        int y = (screenHeight - getHeight()) / 2;
        setLocation(x, y);
    }

    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < countSprites; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < countSprites; i++) {
            sprites[i].render(canvas, g);
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e instanceof BallsOverflowException)
            e.fillInStackTrace();

    }

}

package bricks;

import Bables.Background;
import common.CanvasRepaintListener;
import common.Interactable;
import common.MainCanvas;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements CanvasRepaintListener {
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 400;
    public String nameWindow = "Bricks";
    private final Interactable[] sprites = new Interactable[10];
    private final Background background = new Background();


    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        ScreenLocator();
        setTitle(nameWindow);
        for (int i = 0; i < sprites.length; i++) {
            //sprites[i] = new Brick();
        }
        MainCanvas canvas =new MainCanvas(this);
       add(canvas);

        setVisible(true);
    }


    private void ScreenLocator() {
        int screenWidth = getToolkit().getScreenSize().width;
        int screenHeight = getToolkit().getScreenSize().height;
        // find coordinate window to set
        int x = (screenWidth - getWidth()) / 2;
        int y = (screenHeight - getHeight()) / 2;
        setLocation(x, y);
    }

    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime){
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime){
        for (Interactable sprite : sprites) {
            sprite.update(canvas, deltaTime);
        }
        background.update(canvas, deltaTime);
    }

    private void render(MainCanvas canvas, Graphics g){
        for (Interactable sprite : sprites) {
            sprite.render(canvas, g);
        }
        background.render(canvas,g);
    }

}

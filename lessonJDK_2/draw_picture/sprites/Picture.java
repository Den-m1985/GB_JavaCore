package draw_picture.sprites;

import common.MainCanvas;
import common.Sprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Picture extends Sprite {
    private static final Random rnd = new Random();
    private final Image image;
    private float vX;
    private float vY;
    String imagePath = "draw_picture/resourse/play64.png";

    public Picture(int x, int y) {
        super(x,y);
        halfHeight = 64;
        halfWidth = 64;
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        vX = 100f + rnd.nextFloat(200);
        vY = 100f + rnd.nextFloat(200);
    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;
        if (getLeft() < canvas.getLeft()) {
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        g.drawImage(image, (int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight(), null);
    }

}

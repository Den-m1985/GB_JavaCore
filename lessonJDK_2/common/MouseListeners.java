package common;

import Bables.MainWindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListeners extends MouseAdapter {
    private final MainWindow mainWindow;

    public MouseListeners(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            mainWindow.removeSprite();
        else if (e.getButton() == MouseEvent.BUTTON3) {
            mainWindow.addSprite(e.getX(), e.getY());
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_HEIGHT = 555;
    JButton btnStart, btnExit;
    SettingsWindow settingWindow;
    Map map;

    public GameWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        ScreenLocator();
        setTitle("TicTacToe");
        setResizable(false); // fix window size

        btnStart = new JButton("New Game");
        btnExit = new JButton("Exit");
        settingWindow = new SettingsWindow(this);
        map = new Map();

        btnExit.addActionListener(e -> System.exit(0));
        btnStart.addActionListener(e -> settingWindow.setVisible(true));

        JPanel panButtom = new JPanel(new GridLayout(1, 2));
        panButtom.add(btnStart);
        panButtom.add(btnExit);

        add(panButtom, BorderLayout.SOUTH);
        add(map);

        setVisible(true);
    }


    private void ScreenLocator() {
        // get screen size width and height
        int screenWidth = getToolkit().getScreenSize().width;
        int screenHeight = getToolkit().getScreenSize().height;
        // find coordinate window to set
        int x = (screenWidth - getWidth()) / 2;
        int y = (screenHeight - getHeight()) / 2;
        setLocation(x, y);
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen){
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }

}

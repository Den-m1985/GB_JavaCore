import javax.swing.*;
import java.awt.*;

public class ServerWindow extends JFrame {
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;
    String nameWindow = "Chat server";
    JTextArea textArea;
    ClientGUI clientGUI;
    public boolean isServerWorking;


    public ServerWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        ScreenLocator();
        setTitle(nameWindow);

        add(textField(), BorderLayout.CENTER);
        add(southPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }


    private void ScreenLocator() {
        int screenWidth = getToolkit().getScreenSize().width;
        int screenHeight = getToolkit().getScreenSize().height;
        // find coordinate window to set
        int x = (screenWidth) / 2;
        int y = (screenHeight - getHeight()) / 2;
        setLocation(x, y);
    }


    private JScrollPane textField() {
        textArea = new JTextArea();
        textArea.setWrapStyleWord(true); // перенос по словам
        textArea.setLineWrap(true); // переносит текст если поле заполнено
        textArea.setEditable(false);  // неизменяемый текст
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setBackground(new Color(220, 220, 220));

        return scrollPane;
    }

    private JPanel southPanel() {

        JPanel panel = new JPanel(new BorderLayout());

        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(e -> {
            isServerWorking = true;
            textArea.append("Server started" + System.lineSeparator());
            clientGUI = new ClientGUI();
        });
        JButton btnStop = new JButton("Stop");
        btnStop.addActionListener(e -> {
            isServerWorking = false;
            textArea.append("Server stopped" + System.lineSeparator());
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(btnStart);
        buttonPanel.add(btnStop);

        panel.add(buttonPanel, BorderLayout.CENTER);

        return panel;
    }

}

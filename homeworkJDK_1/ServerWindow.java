import javax.swing.*;
import java.awt.*;

public class ServerWindow extends JFrame {
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;
    private String nameWindow = "Chat server";
    JTextArea textArea;


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
        btnStart.addActionListener(e -> textArea.append("Start"));
        JButton btnStop = new JButton("Stop");
        btnStop.addActionListener(e -> textArea.append("Stop"));

        // Создаем панель для размещения кнопок по центру
        JPanel buttonPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Растягиваем кнопки горизонтально
        gbc.weightx = 1.0; // Устанавливаем вес для растяжения

        buttonPanel.add(btnStart, gbc);
        buttonPanel.add(btnStop, gbc);

        // Размещаем панель с кнопками по центру основной панели
        panel.add(buttonPanel, BorderLayout.CENTER);

        return panel;
    }

}

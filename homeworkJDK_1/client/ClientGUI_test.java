package client;

import server.ServerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class ClientGUI_test extends JFrame implements ClientView {
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;
    private Client client;
    String[] auth;
    String nameWindow = "Chat Client";
    String login;
    int widthButtonSend = 80;
    JTextArea textArea;
    JButton btnAuth;
    JTextArea textFieldFromKeyboard;

    public ClientGUI_test(ServerGUI server) {
        this.client = new Client(this, server);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        ScreenLocator();
        setTitle(nameWindow);

        add(northButton(), BorderLayout.NORTH);
        add(textField(), BorderLayout.CENTER);
        add(sendTextField(), BorderLayout.SOUTH);

        setVisible(true);
    }

    private void ScreenLocator() {
        int screenWidth = getToolkit().getScreenSize().width;
        int screenHeight = getToolkit().getScreenSize().height;
        // find coordinate window to set
        int x = (screenWidth / 2) - getWidth();
        int y = (screenHeight - getHeight()) / 2;
        setLocation(x, y);
    }

    @Override
    public void showMessage(String text) {
        appendLog(text);
    }

    @Override
    public void disconnectFromServer() {
        client.disconnect();
        btnAuth.setVisible(true);
    }

    private void connectToServer() {
        if (client.connectToServer(login)) {
            btnAuth.setVisible(false);
        }
    }


    public void sendMessageToClient() {
        client.sendMessage(textFieldFromKeyboard.getText());
    }

    private JButton northButton() {
        btnAuth = new JButton("Authentication");
        btnAuth.addActionListener(e -> auth = enterLoginPassword());
        return btnAuth;
    }

    public String[] enterLoginPassword() {
        JTextField loginField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        Object[] message = {"Login:", loginField, "Password:", passwordField};

        int option = JOptionPane.showOptionDialog(null, message,
                "Connect server", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if (option == JOptionPane.OK_OPTION) {
            login = loginField.getText();
            String password = new String(passwordField.getPassword());
            connectToServer();
            return new String[]{login, password};
        } else {
            textArea.append("Connect dialog canceled" + System.lineSeparator());
        }
        return null;
    }


    private JScrollPane textField() {
        textArea = new JTextArea();
        textArea.setLineWrap(true); // переносит текст если поле заполнено
        textArea.setEditable(false);  // неизменяемый текст
        textArea.setBackground(new Color(220, 220, 220));
        return new JScrollPane(textArea);
    }

    private void appendLog(String text) {
        textArea.append(text + System.lineSeparator());
    }


    private JPanel sendTextField() {
        JPanel panel = new JPanel(new BorderLayout());
        textFieldFromKeyboard = new JTextArea();
        textFieldFromKeyboard.setLineWrap(true); // переносит текст если поле заполнено
        textFieldFromKeyboard.setBackground(Color.orange);

        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(e -> {
            sendMessageToClient();
            textFieldFromKeyboard.setText(""); // Очищаем поле
        });

        panel.add(textFieldFromKeyboard, BorderLayout.CENTER);
        panel.add(btnSend, BorderLayout.EAST);
        // Устанавливаем высоту кнопки, основываясь на высоте JTextArea в JScrollPane
        int preferredHeight = textFieldFromKeyboard.getPreferredSize().height;
        btnSend.setPreferredSize(new Dimension(widthButtonSend, preferredHeight));

        return panel;
    }


    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING)
            disconnectFromServer();
    }

}

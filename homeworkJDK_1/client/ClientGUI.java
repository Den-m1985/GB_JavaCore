package client;

import server.ServerWindow;
import repository.WriteLog;
import server.ServerWindow_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class ClientGUI extends JFrame {
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;
    private ServerWindow_2 server;
    String nameWindow = "Chat Client";
    String login;
    String path = "Log.txt";
    String IP = "127.0.0.1";
    String PORT = "8080";
    String[] auth;
    int widthButtonSend = 80;
    private boolean connect;
    JTextArea textArea;


    public ClientGUI(ServerWindow_2 server) {
        this.server = server;

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        ScreenLocator();
        setTitle(nameWindow);

        add(northButton(), BorderLayout.NORTH);
        add(textField(), BorderLayout.CENTER);
        add(sendTextField(), BorderLayout.SOUTH);

        //textArea.append(new ReadLog(path).readTxtFile());

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

    private JButton northButton() {
        JButton btnAuth = new JButton("Authentication");
        btnAuth.addActionListener(e -> auth = enterLoginPassword());
        return btnAuth;
    }

    public String[] enterLoginPassword() {
        JTextField ip = new JTextField(IP);
        JTextField port = new JTextField(PORT);
        JTextField loginField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        Object[] message = {"IP: ", ip,
                "Port: ", port,
                "Login:", loginField,
                "Password:", passwordField};

        int option = JOptionPane.showOptionDialog(null, message,
                "Connect server", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if (option == JOptionPane.OK_OPTION) {
            login = loginField.getText();
            String password = new String(passwordField.getPassword());
            //textArea.append("Connect successful" + System.lineSeparator());
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

    public void answer(String text) {
        appendLog(text);
    }


    private JPanel sendTextField() {
        JPanel panel = new JPanel(new BorderLayout());

        JTextArea textField = new JTextArea();
        textField.setLineWrap(true); // переносит текст если поле заполнено
        textField.setBackground(Color.orange);

        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(e -> {
            String text = textField.getText();
            String resultText = text + System.lineSeparator();
            textArea.append(resultText);
            new WriteLog(path).writeTxt(resultText);
            textField.setText(""); // Очищаем JTextArea
        });

        panel.add(textField, BorderLayout.CENTER);
        panel.add(btnSend, BorderLayout.EAST);
        // Устанавливаем высоту кнопки, основываясь на высоте JTextArea в JScrollPane
        int preferredHeight = textField.getPreferredSize().height;
        btnSend.setPreferredSize(new Dimension(widthButtonSend, preferredHeight));

        return panel;
    }
//+++
    private void connectToServer() {
        if (server.connectUser(this)) {
            appendLog("Server connect successful");
            northButton().setVisible(false);
            connect = true;
            String log = server.getLog();
            if (log != null)
                appendLog(log);
            else appendLog("Server connect unsuccessful");
        }
    }


//+++
    public void disconnectFromServer() {
        if (connect){
            northButton().setVisible(true);
            connect = false;
            server.disconnectUser(this);
            appendLog("You was disconnect from server");
        }
    }
//+++
    private void appendLog(String text) {
        textArea.append(text + System.lineSeparator());
    }

    public void messsage(){
        if (connect){
            if (!login.equals("")){
                server.sendMessage(login + " connect");
            }
            appendLog("Server is'n connect");
        }
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING)
            disconnectFromServer();
    }

}

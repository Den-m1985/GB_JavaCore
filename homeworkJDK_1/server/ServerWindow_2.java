package server;

import client.ClientGUI;
import repository.ReadLog;
import repository.WriteLog;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow_2 extends JFrame {
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 500;
    public static String filePathLog = "Log.txt";
    String nameWindow = "Chat server";
    JTextArea textArea;
    public boolean isServerWorking;
    List<ClientGUI> clientList;


    public ServerWindow_2() {
        clientList = new ArrayList<>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        ScreenLocator();
        setTitle(nameWindow);
        setResizable(false);

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

    //+++++
    public boolean connectUser(ClientGUI client){
        if (!isServerWorking)
            return false;
        clientList.add(client);
        return true;
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
            if (isServerWorking){
                appendLog("Сервер уже был запущен");
            } else {
                isServerWorking = true;
                appendLog("Сервер запущен!");
            }

        });
        JButton btnStop = new JButton("Stop");
        btnStop.addActionListener(e -> {
            if (!isServerWorking){
                appendLog("Сервер уже был остановлен");
            } else {
                isServerWorking = false;
                for (ClientGUI clientGUI: clientList){
                    disconnectUser(clientGUI);
                }
                //TODO поправить удаление
                appendLog("Сервер остановлен!");
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(btnStart);
        buttonPanel.add(btnStop);

        panel.add(buttonPanel, BorderLayout.CENTER);

        return panel;
    }
    //+++++
    public String getLog() {
        return new ReadLog(filePathLog).readTxtFile();
    }
    //++++
    public void sendMessage(String text){
        if (isServerWorking)
            return;
        appendLog(text);
        answerAll(text);
        new WriteLog(filePathLog).writeTxt(text);
    }

    private void appendLog(String text){
        textArea.append(text + System.lineSeparator());
    }

    private void answerAll(String text){
        for (ClientGUI clientGUI:clientList) {
            clientGUI.answer(text);
        }
    }
    //++++
    public void disconnectUser(ClientGUI clientGUI){
        clientList.remove(clientGUI);
        if (clientGUI != null){
            clientGUI.disconnectFromServer();
        }
    }

}

package server;

import client.Client;
import client.ClientGUI;
import repository.ReadLog;
import repository.WriteLog;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow extends JFrame {
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 500;
    public static String filePathLog = "repository/Log.txt";
    String nameWindow = "Chat server";
    JTextArea textArea;
    public boolean isServerWorking;
    List<Client> clientList;


    public ServerWindow() {
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


    public boolean connectUser(Client client){
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
                for (int i = 0; i < clientList.size(); i++) {
                    disconnectUser(clientList.get(i));
                }
//                for (Client clientGUI: clientList){
//                    disconnectUser(clientGUI);
//                }
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

    public String getHistory() {
        return new ReadLog(filePathLog).readTxtFile();
    }

    public void sendMessage(String text){

        if (isServerWorking) {
            //appendLog(text);
            answerAll(text);
            //new WriteLog(filePathLog).writeTxt(text);
        }
    }

    private void appendLog(String text){
        textArea.append(text + System.lineSeparator());
    }


    private void answerAll(String text){
        for (Client client:clientList) {
            client.printText(text);
        }
    }

    public void disconnectUser(Client client){
        System.out.println(clientList.size() + "size");
        System.out.println(client.getName());
        clientList.remove(client);
        if (client != null){
            client.disconnect();
        }
    }

}
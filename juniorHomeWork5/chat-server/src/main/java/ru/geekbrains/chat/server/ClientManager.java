package ru.geekbrains.chat.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable {

    private final Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;

    public final static ArrayList<ClientManager> clients = new ArrayList<>();

    public ClientManager(Socket socket) {
        this.socket = socket;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = bufferedReader.readLine();
            clients.add(this);
            System.out.println(name + " подключился к чату.");
            broadcastMessage("Server: " + name + " подключился к чату.");
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }


    }

    @Override
    public void run() {
        String messageFromClient;

        while (socket.isConnected()) {
            try {
                messageFromClient = bufferedReader.readLine();
                /*if (messageFromClient == null){
                    // для  macOS
                    closeEverything(socket, bufferedReader, bufferedWriter);
                    break;
                }*/

                // добавил этот код для отправки личных сообщений
                String receiveName = getReceiveName(messageFromClient);
                boolean ifNamePresent = checkReceiveName(receiveName);

                if (receiveName != null && ifNamePresent) {
                    sendPrivateMessage(receiveName, messageFromClient);
                } else {
                    broadcastMessage(messageFromClient);
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    private void broadcastMessage(String message) {
        for (ClientManager client : clients) {
            try {
                if (!client.name.equals(name)) {
                    client.bufferedWriter.write(message);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    // пытаемся сделать отправку личных собщений
    public void sendPrivateMessage(String receiveName, String message) {
        for (ClientManager client : clients) {
            try {
                if (client.name.equals(receiveName)) {
                    client.bufferedWriter.write(message);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                    break;
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }


    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        // Удаление клиента из коллекции
        removeClient();
        try {
            // Завершаем работу буфера на чтение данных
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            // Завершаем работу буфера для записи данных
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            // Закрытие соединения с клиентским сокетом
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeClient() {
        clients.remove(this);
        System.out.println(name + " покинул чат.");
        broadcastMessage("Server: " + name + " покинул чат.");
    }

    // получем имя получателя сообщения
    public String getReceiveName(String message) {
        int atIndex = message.indexOf(":");
        if (atIndex != -1) {
            String messageNoName = message.substring(atIndex + 1).trim();
            if (messageNoName.startsWith("@")) {
                String str = messageNoName.substring(1).trim();
                String[] strArray = str.split(" ");
                return strArray[0];
            } else return null;
        }
        return null;
    }

    // проверяем есть ли такой клиент в списке
    public boolean checkReceiveName(String receiveName) {
        for (ClientManager client : clients) {
            if (client.name.equals(receiveName)) {
                return true;
            }
        }
        return false;
    }

}

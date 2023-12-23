package org.example;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;
    public static ArrayList<ClientManager> clients = new ArrayList<>();

    public ClientManager(Socket socket) {
        try {
            this.socket = socket;
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = bufferedReader.readLine();
            clients.add(this);
            broadcastMessage("Server: " + name + " connect to chat");
        } catch (IOException e) {
            closeEverething(socket, bufferedReader, bufferedWriter);
        }

    }

    private void broadcastMessage(String massageToSend) {
        for (ClientManager client : clients) {
            try {
                if (!client.name.equals(name)) {
                    client.bufferedWriter.write(massageToSend);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }
            } catch (IOException e) {
                closeEverething(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    private void closeEverething(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClients();
        try {
            if (bufferedReader != null) bufferedReader.close();
            if (bufferedWriter != null) bufferedWriter.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeClients() {
        clients.remove(this);
        broadcastMessage("Server: " + name + " disconnect");
    }

    @Override
    public void run() {
        String massageFromClient;
        while (socket.isConnected()) {
            try {
                massageFromClient = bufferedReader.readLine();
                broadcastMessage(massageFromClient);
            } catch (IOException e) {
                closeEverething(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

}

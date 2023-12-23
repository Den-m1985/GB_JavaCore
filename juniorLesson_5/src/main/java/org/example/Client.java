package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;

    public Client(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
        try {
            this.socket = socket;
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            closeEverething(socket, bufferedReader, bufferedWriter);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter our name: ");
        String name = scanner.nextLine();
        Socket socket = new Socket("localhost", 1300);
        Client client = new Client(socket, name);
        client.listenForMassage();
        client.sendMassage();
    }

    public void sendMassage() {
        try {
            bufferedWriter.write(name);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            Scanner scanner = new Scanner(System.in);
            while (socket.isConnected()) {
                String massage = scanner.nextLine();
                bufferedWriter.write(name + ": " + massage);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

        } catch (IOException e) {
            closeEverething(socket, bufferedReader, bufferedWriter);
        }
    }

    public void listenForMassage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String massageFromGroup;
                while (socket.isConnected()) {
                    try {
                        massageFromGroup = bufferedReader.readLine();
                        System.out.println(massageFromGroup);
                    } catch (IOException e) {
                        closeEverething(socket, bufferedReader, bufferedWriter);
                    }

                }
            }
        }).start();
    }


    private void closeEverething(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if (bufferedReader != null) bufferedReader.close();
            if (bufferedWriter != null) bufferedWriter.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

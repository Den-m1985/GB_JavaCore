package org.example.exampleClientServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample1 {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            Socket client = new Socket(inetAddress, 1300);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
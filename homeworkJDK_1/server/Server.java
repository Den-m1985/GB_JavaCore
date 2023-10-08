package server;

import client.Client;
import repository.Storage;

import java.util.ArrayList;
import java.util.List;

public class Server {
    public Storage storage = new Storage();
    public boolean isServerWorking;
    List<Client> clientList;


    public Server() {
        clientList = new ArrayList<>();
    }


    public boolean connectUser(Client client) {
        if (!isServerWorking)
            return false;
        clientList.add(client);
        return true;
    }

    public void disconnectUser(Client client) {
        clientList.remove(client);
        if (client != null) {
            client.disconnect();
        }
    }


    public void disconnectAllUsers() {
        for (int i = 0; i < clientList.size(); i++) {
            Client client = clientList.get(i);
            disconnectUser(client);
        }
    }


    public void sendMessage(String text) {
        if (isServerWorking) {
            answerAll(text);
            storage.setHistory(text);
        }
    }


    private void answerAll(String text) {
        for (Client client : clientList) {
            client.printText(text);
        }
    }


    public String getHistory() {
        return storage.getHistory();
    }


    public void setHistory(String text) {
        storage.setHistory(text);
    }

    public void setServerWorking(boolean serverWorking) {
        isServerWorking = serverWorking;
    }

    public boolean isServerWorking() {
        return isServerWorking;
    }

}

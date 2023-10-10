package client;

import server.ServerGUI;

public class Client {

    private String name;
    private final ClientGUI clientView;
    private final ServerGUI serverGui;
    private boolean connected;

    public Client(ClientGUI clientView, ServerGUI serverGUI) {
        this.clientView = clientView;
        this.serverGui = serverGUI;
    }

    public boolean connectToServer(String name) {
        this.name = name;
        if (serverGui.server.connectUser(this)) {
            printText("Вы успешно подключились!" + System.lineSeparator());
            connected = true;
            String log = serverGui.server.getHistory();
            if (log != null) {
                printText(log);
            }
            return true;
        } else {
            printText("Подключение не удалось");
            return false;
        }
    }

    public void sendMessage(String message) {
        if (connected) {
            if (!message.isEmpty()) {
                serverGui.server.sendMessage(name + ": " + message);
            }
        } else {
            printText("Нет подключения к серверу");
        }
    }

    public void disconnect() {
        if (connected) {
            connected = false;
            clientView.disconnectFromServer();
            serverGui.server.disconnectUser(this);
            printText("Вы были отключены от сервера!");
        }
    }

    public void printText(String text) {
        clientView.showMessage(text);
    }

}

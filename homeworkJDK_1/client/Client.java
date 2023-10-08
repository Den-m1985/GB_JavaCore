package client;

import server.ServerGUI;

public class Client {

    private String name;
    private final ClientGUI_test clientView;
    private final ServerGUI serverGui;
    private boolean connected;

    public Client(ClientGUI_test clientView, ServerGUI serverWindow) {
        this.clientView = clientView;
        this.serverGui = serverWindow;
    }

    public boolean connectToServer(String name) {
        this.name = name;
        if (serverGui.server.connectUser(this)) {
            printText("Вы успешно подключились!\n");
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

    //мы посылаем
    public void sendMessage(String message) {
        if (connected) {
            if (!message.isEmpty()) {
                serverGui.server.sendMessage(name + ": " + message);
            }
        } else {
            printText("Нет подключения к серверу");
        }
    }

    //нам посылают
    public void serverAnswer(String answer) {
        printText(answer);
    }

    public void disconnect() {
        if (connected) {
            connected = false;
            clientView.disconnectFromServer();
            serverGui.server.disconnectUser(this);
            printText("Вы были отключены от сервера!");
        }
    }

    public String getName() {
        return name;
    }

    public void printText(String text) {
        clientView.showMessage(text);
    }

}

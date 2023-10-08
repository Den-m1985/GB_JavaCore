import client.ClientGUI_test;
import server.ServerGUI;

public class Main {

    public static void main(String[] args) {
        ServerGUI serverGUI = new ServerGUI();
        new ClientGUI_test(serverGUI);
        new ClientGUI_test(serverGUI);
    }

}

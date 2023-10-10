import client.ClientGUI;
import server.ServerGUI;

public class Main {

    public static void main(String[] args) {
        ServerGUI serverGUI = new ServerGUI();
        int count = 4;
        for (int i = 0; i < count; i++) {
            new ClientGUI(serverGUI);
        }
    }

}

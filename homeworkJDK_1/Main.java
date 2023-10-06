import client.ClientGUI;
import server.ServerWindow;

public class Main {

    public static void main(String[] args) {
        //new client.ClientGUI();
        ServerWindow serverWindow =new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }

}

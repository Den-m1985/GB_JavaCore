import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class ClientGUI extends JFrame {
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;
    String STDOUT_ENCODING = "windows-1251";
    String[] auth;
    JButton btnAuth;

    public ClientGUI() throws UnsupportedEncodingException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        ScreenLocator();
        setTitle("Chat Client");

        JTextArea textArea = textField();

        btnAuth = new JButton("Authentication");
        btnAuth.addActionListener(e -> auth = enterLoginPassword());

        add(btnAuth, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);  // create text field

        setVisible(true);
    }


    private JTextArea textField() throws UnsupportedEncodingException {
        JTextArea textArea = new JTextArea();
        textArea.setBackground(new Color(220, 220, 220));  // background color
        //  print text to text area
        PrintStream printStream = new PrintStream(new OutputStreamEncoding(textArea, STDOUT_ENCODING),
                true, STDOUT_ENCODING);
        // re-assigns standard output stream and error output stream
        System.setOut(printStream);
        System.setErr(printStream);
        return textArea;
    }


    private void ScreenLocator() {
        // get screen size width and height
        int screenWidth = getToolkit().getScreenSize().width;
        int screenHeight = getToolkit().getScreenSize().height;
        // find coordinate window to set
        int x = (screenWidth - getWidth()) / 2;
        int y = (screenHeight - getHeight()) / 2;
        setLocation(x, y);
    }


    public String[] enterLoginPassword() {

        JTextField loginField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        Object[] message = {"Login:", loginField, "Password:", passwordField};
        ImageIcon iconLogin = new ImageIcon("enter40.png");

        int option = JOptionPane.showOptionDialog(null, message,
                "Login and Password", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE, iconLogin, null, null);
        if (option == JOptionPane.OK_OPTION) {
            String login = loginField.getText();
            String password = new String(passwordField.getPassword());
            System.out.println("Login and Password add");
            return new String[]{login, password};
        } else {
            System.out.println("Login and Password dialog canceled");
        }
        return null;
    }

}

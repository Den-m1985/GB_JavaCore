import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ClientGUI extends JFrame {
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;
    private String nameWindow = "Chat Client";
    String[] auth;
    JTextArea textArea;


    public ClientGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        ScreenLocator();
        setTitle(nameWindow);

        add(northButton(), BorderLayout.NORTH);
        add(textField(), BorderLayout.CENTER);
        add(sendTextField(), BorderLayout.SOUTH);

        setVisible(true);
    }


    private void ScreenLocator() {
        int screenWidth = getToolkit().getScreenSize().width;
        int screenHeight = getToolkit().getScreenSize().height;
        // find coordinate window to set
        int x = (screenWidth / 2) - getWidth();
        int y = (screenHeight - getHeight()) / 2;
        setLocation(x, y);
    }


    private JButton northButton(){
        JButton btnAuth = new JButton("Authentication");
        btnAuth.addActionListener(e -> auth = enterLoginPassword());
        return btnAuth;
    }


    public String[] enterLoginPassword() {
        JTextField loginField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        Object[] message = {"Login:", loginField, "Password:", passwordField};

        int option = JOptionPane.showOptionDialog(null, message,
                "Login and Password", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if (option == JOptionPane.OK_OPTION) {
            String login = loginField.getText();
            String password = new String(passwordField.getPassword());
            textArea.append("Login and Password add");
            return new String[]{login, password};
        } else {
            textArea.append("Login and Password dialog canceled");
        }
        return null;
    }


    private JScrollPane textField() {
        textArea = new JTextArea();
        textArea.setWrapStyleWord(true); // перенос по словам
        textArea.setLineWrap(true); // переносит текст если поле заполнено
        textArea.setEditable(false);  // неизменяемый текст
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setBackground(new Color(220, 220, 220));

        return scrollPane;
    }


    private JPanel sendTextField() {

        JPanel panel = new JPanel(new GridBagLayout());
        Border panelBorder = BorderFactory.createLineBorder(Color.gray,2);
        panel.setBorder(panelBorder);

        JTextArea textField = new JTextArea();
        textField.setWrapStyleWord(true); // перенос по словам
        textField.setLineWrap(true); // переносит текст если поле заполнено
        textField.setBackground(Color.orange);

        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(e -> {
            String text = textField.getText();
            textArea.append(text + System.lineSeparator());
            textField.setText(""); // Очищаем JTextArea
        });

        // Добавляем JTextField и JButton на панель с GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Растягиваем JTextArea по высоте и ширине
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel.add(textField, gbc);

        gbc.fill = GridBagConstraints.VERTICAL; // Растягиваем кнопку по высоте
        gbc.weightx = 0.0;
        gbc.weighty = 1.0;
        panel.add(btnSend, gbc);

        // Устанавливаем высоту кнопки, основываясь на высоте JTextArea в JScrollPane
        int preferredHeight = textField.getPreferredSize().height;
        btnSend.setPreferredSize(new Dimension(80, preferredHeight));

        return panel;
    }

}

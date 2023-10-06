
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exeptional extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {

    Exeptional() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(1100, 200, 500, 300);
        setTitle("nameWindow");
        JButton btn = new JButton("Push");
        add(btn);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Exeptional();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new ArrayIndexOutOfBoundsException("something wrong");
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Exeption", JOptionPane.ERROR_MESSAGE);
    }
}

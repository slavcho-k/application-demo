import javax.swing.*;
import java.awt.*;

public class AfterLogin {
    JFrame frame = new JFrame();
    JLabel welcomeLabel;

    public AfterLogin(String username) {
        welcomeLabel = new JLabel("Hello " + username);
        welcomeLabel.setBounds(0, 0, 200, 35);
        welcomeLabel.setFont(new Font(null, Font.BOLD, 25));

        frame.add(welcomeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

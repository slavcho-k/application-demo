import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Login implements ActionListener {
    JFrame frame;
    JButton loginBtn;
    JButton resetBtn;
    JTextField userId;
    JPasswordField password;
    JLabel userIdLabel;
    JLabel userPassLabel;
    JLabel message;

    HashMap<String, String> loginInfo;

    public Login(HashMap<String, String> hashMap) {
        loginInfo = hashMap;

        userIdLabel = new JLabel("Username: ");
        userIdLabel.setBounds(50, 100, 75, 25);

        userPassLabel = new JLabel("Password:");
        userPassLabel.setBounds(50, 150, 75, 25);

        message = new JLabel();
        message.setBounds(125, 250, 250, 35);
        message.setFont(new Font(null, Font.BOLD, 25));

        userId = new JTextField();
        userId.setBounds(125, 100, 200, 25);

        password = new JPasswordField();
        password.setBounds(125, 150, 200, 25);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(125, 200, 100, 25);
        loginBtn.addActionListener(this);
        loginBtn.setFocusable(false);

        resetBtn = new JButton("Reset");
        resetBtn.setBounds(225, 200, 100, 25);
        resetBtn.setFocusable(false);
        resetBtn.addActionListener(this);

        frame = new JFrame();
        //frame.setLocationRelativeTo(null);
        frame.add(userIdLabel);
        frame.add(userPassLabel);
        frame.add(message);
        frame.add(userId);
        frame.add(password);
        frame.add(loginBtn);
        frame.add(resetBtn);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetBtn) {
            userId.setText("");
            password.setText("");
            message.setText("");
        }
        if (e.getSource() == loginBtn) {
            String username = userId.getText();
            String pass = String.valueOf(password.getPassword());
            if (checkCredentials(username, pass)) {
                message.setForeground(Color.blue);
                message.setText("Logged in");
                AfterLogin welcomePage = new AfterLogin(username);
                frame.dispose();
            } else {
                message.setForeground(Color.red);
                message.setText("Wrong credentials");
            }
        }
    }

    private boolean checkCredentials(String user, String pass) {
        return loginInfo.containsKey(user) && loginInfo.get(user).equals(pass);
    }
}

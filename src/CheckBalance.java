import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBalance implements ActionListener {
    JFrame frame;
    JLabel title;
    JLabel usernameLabel;
    JLabel username;
    JLabel identificationLabel;
    JLabel idNum;
    JLabel balanceLabel;
    JLabel balance;
    JButton backBtn;

    public CheckBalance() {
        title = new JLabel("Check balance");
        title.setBounds(20, 20, 200, 35);
        title.setFont(new Font(null, Font.BOLD, 25));

        backBtn = new JButton("Back");
        backBtn.setBounds(20, 80, 200, 35);
        backBtn.addActionListener(this);
        backBtn.setFocusable(false);

        usernameLabel = new JLabel("Username: ");
        usernameLabel.setBounds(20, 130, 200, 35);
        //TODO fix username here
        username = new JLabel(BankAccount.getUsername());
        username.setBounds(90, 130, 200, 35);

        identificationLabel = new JLabel("Identification: ");
        identificationLabel.setBounds(20, 190, 200, 35);
        idNum = new JLabel(BankAccount.getId());
        idNum.setBounds(105, 190, 200, 35);

        balanceLabel = new JLabel("Balance: ");
        balanceLabel.setBounds(20, 250, 200, 35);
        balance = new JLabel(BankAccount.getBalanceString());
        balance.setBounds(75, 250, 200, 35);

        frame = new JFrame();
        frame.add(title);
        frame.add(backBtn);
        frame.add(usernameLabel);
        frame.add(username);
        frame.add(identificationLabel);
        frame.add(idNum);
        frame.add(balanceLabel);
        frame.add(balance);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 768);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            //TODO fix username
            AfterLogin welcomePage = new AfterLogin(username.getText());
            frame.dispose();
        }
    }
}

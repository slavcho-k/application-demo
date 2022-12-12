import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfterLogin implements ActionListener {
    JFrame frame;
    JLabel welcomeLabel;
    JLabel bankAppLabel;
    JButton checkStateBtn;
    JButton depositBtn;
    JButton withdrawBtn;
    JButton sendMoneyBtn;

    public AfterLogin(String username) {
        bankAppLabel = new JLabel("Banking Application");
        bankAppLabel.setBounds(20, 10, 300, 35);
        bankAppLabel.setFont(new Font(null, Font.BOLD, 25));

        welcomeLabel = new JLabel("Hello, " + username);
        welcomeLabel.setBounds(20, 50, 200, 35);
        welcomeLabel.setFont(new Font(null, Font.PLAIN, 22));

        checkStateBtn = new JButton("Check state");
        checkStateBtn.setBounds(20, 110, 200, 25);
        checkStateBtn.addActionListener(this);
        checkStateBtn.setFocusable(false);

        depositBtn = new JButton("Deposit");
        depositBtn.setBounds(20, 170, 200, 25);
        depositBtn.addActionListener(this);
        depositBtn.setFocusable(false);

        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(20, 230, 200, 25);
        withdrawBtn.addActionListener(this);
        withdrawBtn.setFocusable(false);

        sendMoneyBtn = new JButton("Send money");
        sendMoneyBtn.setBounds(20, 290, 200, 25);
        sendMoneyBtn.addActionListener(this);
        sendMoneyBtn.setFocusable(false);

        frame = new JFrame();
        frame.add(bankAppLabel);
        frame.add(welcomeLabel);
        frame.add(checkStateBtn);
        frame.add(depositBtn);
        frame.add(withdrawBtn);
        frame.add(sendMoneyBtn);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 768);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkStateBtn) {
            CheckState checkState = new CheckState();
            frame.dispose();
        }
        if (e.getSource() == depositBtn) {
            DepositMoney depositMoney = new DepositMoney();
            frame.dispose();
        }
        if (e.getSource() == withdrawBtn) {
            WithdrawMoney withdrawMoney = new WithdrawMoney();
            frame.dispose();
        } else {
            SendMoney sendMoney = new SendMoney();
            frame.dispose();
        }
    }
}

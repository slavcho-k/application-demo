import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WithdrawMoney implements ActionListener {
    JFrame frame;
    JLabel title;
    JButton backBtn;
    JButton confirmBtn;
    JLabel dateLabel;
    JLabel date;
    JLabel idLabel;
    JLabel id;
    JLabel amountLabel;
    JFormattedTextField amount;

    public WithdrawMoney() {
        title = new JLabel("Withdraw money");
        title.setBounds(20, 20, 200, 35);
        title.setFont(new Font(null, Font.BOLD, 25));

        backBtn = new JButton("Back");
        backBtn.setBounds(20, 80, 200, 35);
        //backBtn.setBounds(20, 20, 200, 35);
        backBtn.addActionListener(this);
        backBtn.setFocusable(false);

        idLabel = new JLabel("Identification: ");
        idLabel.setBounds(20, 130, 200, 35);
        id = new JLabel(BankAccount.getId());
        id.setBounds(105, 130, 200, 35);

        dateLabel = new JLabel("Deposit date: ");
        dateLabel.setBounds(20, 190, 200, 35);
        date = new JLabel(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        date.setBounds(105, 190, 200, 35);

        amountLabel = new JLabel("Amount: ");
        amountLabel.setBounds(20, 250, 200, 35);
        amount = new JFormattedTextField(numberFormatter());
        amount.setText("0");
        amount.setBounds(77, 258, 100, 20);

        confirmBtn = new JButton("Withdraw");
        confirmBtn.setBounds(20, 310, 200, 35);
        confirmBtn.addActionListener(this);
        confirmBtn.setFocusable(false);

        frame = new JFrame();
        frame.add(title);
        frame.add(backBtn);
        frame.add(idLabel);
        frame.add(id);
        frame.add(dateLabel);
        frame.add(date);
        frame.add(amountLabel);
        frame.add(amount);
        frame.add(confirmBtn);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 768);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            //TODO fix username
            AfterLogin welcomePage = new AfterLogin("Some user");
            frame.dispose();
        }
        if (e.getSource() == confirmBtn) {
            if (amount.getText().equals("0"))
                JOptionPane.showMessageDialog(frame, "You cannot withdraw $0");
            else {
                String am = amount.getText();
                am = am.replace(",", "");
                amount.setText("0");
                if (Integer.parseInt(am) > BankAccount.getBalance())
                    JOptionPane.showMessageDialog(frame, "You cannot withdraw more money than you have!");
                else
                    BankAccount.updateBal(Integer.parseInt(am), "-");
            }
        }
    }

    private NumberFormatter numberFormatter() {
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        return formatter;
    }


}


import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class SendMoney implements ActionListener {
    JFrame frame;
    JLabel title;
    JLabel idLabelSender;
    JLabel idSender;
    JLabel amountLabel;
    JFormattedTextField amount;
    JLabel idLabelReciever;
    JFormattedTextField idReciever;
    JLabel dateLabel;
    JLabel date;
    JButton confirmBtn;
    JButton backBtn;

    public SendMoney() {
        title = new JLabel("Send money");
        title.setBounds(20, 20, 200, 35);
        title.setFont(new Font(null, Font.BOLD, 25));

        backBtn = new JButton("Back");
        backBtn.setBounds(20, 80, 200, 35);
        backBtn.addActionListener(this);
        backBtn.setFocusable(false);

        idLabelSender = new JLabel("Sender ID:");
        idLabelSender.setBounds(20, 130, 200, 35);
        idSender = new JLabel(BankAccount.getId());
        idSender.setBounds(90, 130, 200, 35);

        idLabelReciever = new JLabel("Reciever ID:");
        idLabelReciever.setBounds(20, 190, 200, 35);
        idReciever = new JFormattedTextField(numberFormatter(false));
        idReciever.setBounds(100, 198, 100, 20);

        dateLabel = new JLabel("Transaction date: ");
        dateLabel.setBounds(20, 250, 200, 35);
        date = new JLabel(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        date.setBounds(130, 250, 200, 35);

        amountLabel = new JLabel("Amount");
        amountLabel.setBounds(20, 310, 200, 35);
        amount = new JFormattedTextField(numberFormatter(true));
        amount.setText("0");
        amount.setBounds(75, 318, 100, 20);

        confirmBtn = new JButton("Make Transaction");
        confirmBtn.setBounds(20, 370, 200, 35);
        confirmBtn.addActionListener(this);
        confirmBtn.setFocusable(false);

        frame = new JFrame();
        frame.add(title);
        frame.add(backBtn);
        frame.add(idLabelSender);
        frame.add(idSender);
        frame.add(idLabelReciever);
        frame.add(idReciever);
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
                JOptionPane.showMessageDialog(frame, "You cannot send $0");
            else {
                String am = amount.getText();
                am = am.replace(",", "");
                Transaction t = new Transaction(idReciever.getText(), am);
                if (!t.checkTransaction()) {
                    JOptionPane.showMessageDialog(frame, "Transaction cannot be processed");
                } else {
                    int input = JOptionPane.showConfirmDialog(frame, "Are you sure you want to proceed?", "Question", JOptionPane.YES_NO_OPTION);
                    if (input == 0) {
                        BankAccount.updateBal((int) t.getAmount(), "-");
                        JOptionPane.showMessageDialog(frame, "Transaction succsesfull");
                        idReciever.setText("0");
                        amount.setText("0");
                    }
                }
            }
        }
    }

    private NumberFormatter numberFormatter(boolean flag) {
        NumberFormat format = NumberFormat.getInstance();
        if (!flag)
            format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        return formatter;
    }
}

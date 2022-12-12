import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawMoney implements ActionListener {
    JFrame frame;
    JButton backBtn;

    public WithdrawMoney() {
        backBtn = new JButton("Back");
        backBtn.setBounds(20, 20, 200, 35);
        backBtn.addActionListener(this);
        backBtn.setFocusable(false);

        frame = new JFrame();
        frame.add(backBtn);
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
    }
}

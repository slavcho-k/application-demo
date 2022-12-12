import java.util.Random;

public class BankAccount {
    static String username;
    static int id;
    static double balance;

    public BankAccount(String username) {
        BankAccount.username = username;
        id = new Random().nextInt(900000) + 100000;
        balance = Math.round(Math.random() * 9000000d) / 100d;
    }

    public static String getUsername() {
        return String.format("%s", username);
    }

    public static String getId() {
        return String.format("%06d", id);
    }

    public static String getBalanceString() {
        return String.format("%.2f$", balance);
    }

    public static void updateBal(int amount, String op) {
        if (op.equals("+"))
            BankAccount.balance += amount;
        else
            BankAccount.balance -= amount;
    }
}

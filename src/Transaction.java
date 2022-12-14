public class Transaction {
    String senderId;
    String recieverId;
    double amount;

    //TODO ovde proverka dali moze da se napravi transakcija
    //ako moze se pravi ako ne vraka nesto false za da ima tamu
    //todo proverkata za reciever id se pravi preku static addreses to send to
    //

    public Transaction(String recieverId, String amount) {
        this.senderId = BankAccount.getId();
        this.recieverId = recieverId;
        this.amount = Double.parseDouble(amount);
    }

    public boolean checkTransaction() {
        if (!AddressesToSendTo.ids.contains(recieverId))
            return false;
        return !(amount > BankAccount.getBalance());
    }

    public double getAmount() {
        return amount;
    }
}

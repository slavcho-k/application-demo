public class Main {
    public static void main(String[] args) {
        UserAndPass userPass = new UserAndPass();
        AddressesToSendTo ats = new AddressesToSendTo();
        Login loginPage = new Login(userPass.getLoginInfo());
        //TODO da se fixira username kaj checkstate
        //TODO da se fixira username kaj site
        BankAccount bankAccount = new BankAccount("random user");
        //ova podole e za testiranje bez login
        //AfterLogin welcomePage = new AfterLogin("username");
        //AddressesToSendTo at = new AddressesToSendTo();
    }
}
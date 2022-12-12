public class Main {
    public static void main(String[] args) {
        UserAndPass userPass = new UserAndPass();
        //Login loginPage = new Login(userPass.getLoginInfo());
        //TODO da se fixira username kaj checkstate
        BankAccount bankAccount = new BankAccount("random user");
        AfterLogin welcomePage = new AfterLogin("username");
    }
}
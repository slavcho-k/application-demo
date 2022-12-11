
public class Main {
    public static void main(String[] args) {
        UserAndPass userPass = new UserAndPass();
        Login loginPage = new Login(userPass.getLoginInfo());
    }
}
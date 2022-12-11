import java.util.HashMap;

public class UserAndPass {
    HashMap<String, String> loginInfo;

    public UserAndPass() {
        this.loginInfo = new HashMap<>();
        loginInfo.put("admin800", "123456788");
        loginInfo.put("slav4o.mkd", "987654321");
        loginInfo.put("random123", "gostivar123");
    }

    protected HashMap<String, String> getLoginInfo() {
        return loginInfo;
    }
}

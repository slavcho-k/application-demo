import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddressesToSendTo {
    static List<String> ids;

    public AddressesToSendTo() {
        ids = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ids.add(String.valueOf(new Random().nextInt(9000000) + 100000));
            //System.out.println(ids.get(i));
        }
        //ova za polesno testiranje
        ids.add("111111");
    }
}

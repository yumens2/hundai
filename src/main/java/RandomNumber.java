import java.util.ArrayList;
import java.util.Random;

public class RandomNumber {

    public static ArrayList<Integer> generateRandomNumber() {
        ArrayList<Integer> target = new ArrayList<>(Constant.NUM);
        Random random = new Random(System.currentTimeMillis());
        while (target.size() < Constant.NUM) {
            Integer num = random.nextInt(9) + 1;
            if (!target.contains(num)) {
                target.add(num);
            }
        }
        return target;
    }
}

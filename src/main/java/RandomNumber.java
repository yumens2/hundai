import java.util.ArrayList;
import java.util.Random;

public class RandomNumber {
    private static final int SIZE = 3;
    public static ArrayList<Integer> generateRandomNumber(){
        ArrayList<Integer> target = new ArrayList<>(SIZE);
        Random random = new Random(System.currentTimeMillis());
        while(target.size() < SIZE){
            Integer num = random.nextInt(9) + 1;
            if(!target.contains(num)) target.add(num);
        }
        return target;
    }
}

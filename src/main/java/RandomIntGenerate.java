import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class RandomIntGenerate {
    public static List<Integer> init() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            nums.add(generateNumber(nums));
        }
        return nums;
    }
    private static int generateNumber(List<Integer> nums){
        Random random = new Random();
        int randInt;
        do {
            randInt = random.nextInt(9) + 1;
        } while (nums.contains(randInt));
        return randInt;
    }
}

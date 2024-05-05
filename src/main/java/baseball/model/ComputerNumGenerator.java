package baseball.model;

import java.util.Arrays;
import java.util.Random;

public class ComputerNumGenerator {
    public final int[] NUMS;
    public static final int NUMS_LENGTH = 3;

    public ComputerNumGenerator() {
        int[] nums;
        do {
            nums = makeComputerNums();
        } while (!isNotDuplicate(nums));
        NUMS = nums;
    }

    private static int[] makeComputerNums() {
        Random random = new Random();

        return Arrays.stream(new int[NUMS_LENGTH])
            .map(num -> random.nextInt(9) + 1)
            .toArray();
    }

    public static boolean isNotDuplicate(int[] nums) {
        return nums.length == Arrays.stream(nums).distinct().count();
    }
}

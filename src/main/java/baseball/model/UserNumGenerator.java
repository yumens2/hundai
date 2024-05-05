package baseball.model;

import baseball.view.InputView;
import java.util.Arrays;

public class UserNumGenerator {
    public final int[] NUMS;

    public UserNumGenerator() {
        this.NUMS = setUserNums();
    }

    private static int[] setUserNums() throws IllegalArgumentException {
        String numString = InputView.startInput();
        int[] nums = stringToIntArray(numString);
        if (isNotException(nums)) {
            return nums;
        }
        throw new IllegalArgumentException();
    }

    public static int[] stringToIntArray(String str) {
        return str.chars()
            .map(num -> num - '0')
            .toArray();
    }

    private static boolean isNotException(int[] nums) {
        return nums.length == 3 && isOneNineInt(nums) && isNotDuplicate(nums);
    }

    private static boolean isNotDuplicate(int[] nums) {
        return nums.length == Arrays.stream(nums).distinct().count();
    }

    private static boolean isOneNineInt(int[] numArray) {
        return Arrays.stream(numArray)
            .allMatch(num -> 1 <= num && num <= 9);
    }
}

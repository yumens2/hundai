package baseball.controller;

import java.util.Arrays;
import java.util.stream.Stream;

public class NumberCompare {
    public static final int NUMS_LENGTH = 3;

    public final int BALL_COUNT;
    public final int STRIKE_COUNT;

    public NumberCompare(int[] userNums, int[] computerNums){
        BALL_COUNT = BallCount(userNums, computerNums);
        STRIKE_COUNT = StrikeCount(userNums, computerNums);
    }

    private int BallCount(int[] userNums, int[] computerNums){
        /*int count = 0;
        for (int i = 0; i < Constant.NUMS_LENGTH; i++) {
            if (userNums[i] != computerNums[i] && Util.isInArray(userNums[i], computerNums)) {
                count++;
            }
        }*/
        return (int) Stream.iterate(0, i -> i + 1).limit(NUMS_LENGTH)
            .filter(i -> userNums[i] != computerNums[i] && isInArray(userNums[i], computerNums))
            .count();
    }

    private int StrikeCount(int[] userNums, int[] computerNums){
        return (int) Stream.iterate(0, i -> i + 1).limit(NUMS_LENGTH)
            .filter(i -> userNums[i] == computerNums[i])
            .count();
    }

    public boolean isMaxStrike() {
        return STRIKE_COUNT == NUMS_LENGTH;
    }

    public static boolean isInArray(int num, int[] nums) {
        return Arrays.stream(nums).anyMatch(arrayNum -> arrayNum == num);
    }

}

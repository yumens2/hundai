package baseball;

import java.util.List;

public class GameLogic {
    public int countStrikes(String input, List<Integer> computerNumbers) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            int digit = Character.getNumericValue(input.charAt(i));
            if (digit == computerNumbers.get(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    public int countBalls(String input, List<Integer> computerNumbers) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            int digit = Character.getNumericValue(input.charAt(i));
            if (computerNumbers.contains(digit) && digit != computerNumbers.get(i)) {
                balls++;
            }
        }
        return balls;
    }
}
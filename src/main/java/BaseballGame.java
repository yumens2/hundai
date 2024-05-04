import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BaseballGame {
    public void startGame() {
        System.out.println("Game started");
        playGame();
    }

    public void playGame() {
        int[] targetNumbers = generateRandomNumbers();
        System.out.println(Arrays.toString(targetNumbers));
    }

    public static int[] generateRandomNumbers() {
        ArrayList<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            digits.add(i);
        }
        Collections.shuffle(digits);

        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = digits.get(i);
        }
        return result;
    }
}

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Player {

    private final int[] answer = new int[GameConstant.NUMBER_COUNT];
    Set<Integer> numbers = new HashSet<>();

    public Player() {
        createRandomAnswer();
    }

    private void createRandomAnswer() {
        numbers.clear();
        while (numbers.size() < GameConstant.NUMBER_COUNT) {
            int number = createRandomNumber();
            numbers.add(number);
        }
        int index = 0;
        for (int number : numbers) {
            answer[index++] = number;
        }
    }

    private int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public GameResult checkMatching(int[] guess) {
        int ball = checkBall(guess);
        int strike = checkStrike(guess);
        return new GameResult(ball, strike);
    }

    private int checkBall(int[] guess) {
        int count = 0;
        for (int i = 0; i < GameConstant.NUMBER_COUNT; i++) {
            if (answer[i] == guess[i]) {
                continue;
            }
            if (numbers.contains(guess[i])) {
                count++;
            }
        }
        return count;
    }

    private int checkStrike(int[] guess) {
        int count = 0;
        for (int i = 0; i < GameConstant.NUMBER_COUNT; i++) {
            if (answer[i] == guess[i]) {
                count++;
            }
        }
        return count;
    }
}

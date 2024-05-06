import constant.GameConstant;
import data.GameResult;
import java.util.HashSet;
import java.util.Set;

public class Player {

    private int[] answer = new int[GameConstant.NUMBER_COUNT];
    Set<Integer> numbers = new HashSet<>();

    public Player() {
        createRandomAnswer();
    }

    private void createRandomAnswer() {
        answer = RandomNumberGenerator.generate(GameConstant.NUMBER_COUNT);
        for (int i = 0; i < GameConstant.NUMBER_COUNT; i++) {
            numbers.add(answer[i]);
        }
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

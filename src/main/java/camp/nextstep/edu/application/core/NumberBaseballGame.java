package camp.nextstep.edu.application.core;

import java.util.LinkedList;
import java.util.List;

public class NumberBaseballGame {

    private GameState state;
    private final RandomNumberGenerator randomNumberGenerator;
    private final List<Integer> answers = new LinkedList<>();

    public NumberBaseballGame(
            InputValueValidationStrategy strategy,
            RandomNumberGenerator randomNumberGenerator
    ) {
        state = GameState.READY;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void run() {
        if(state != GameState.READY) {
            throw new IllegalStateException("Game is not ready or already running.");
        }
        state = GameState.RUNNING;
        generateNewAnswers();
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public boolean isRunning() {
        return state == GameState.RUNNING || state == GameState.PAUSED;
    }

    private void generateNewAnswers() {
        answers.clear();
        while (answers.size() < 3) {
            int number = randomNumberGenerator.nextInt(1, 9);
            if (!answers.contains(number)) {
                answers.add(number);
            }
        }
    }

}

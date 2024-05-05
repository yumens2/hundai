package camp.nextstep.edu.application.core;

import java.util.LinkedList;
import java.util.List;

public class NumberBaseballGame {

    private GameState state;
    private final InputValueValidationStrategy strategy;
    private final RandomNumberGenerator randomNumberGenerator;
    private final DefenseResultMatcher defenseResultMatcher;
    private final List<Integer> answers = new LinkedList<>();

    public NumberBaseballGame(
            InputValueValidationStrategy strategy,
            RandomNumberGenerator randomNumberGenerator,
            DefenseResultMatcher defenseResultMatcher
    ) {
        state = GameState.READY;
        this.strategy = strategy;
        this.randomNumberGenerator = randomNumberGenerator;
        this.defenseResultMatcher = defenseResultMatcher;
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

    public void onInputSubmitted(String input) {
        if (!isRunning()) {
            throw new IllegalStateException("Game is not running.");
        }
        if(state == GameState.PAUSED) {
            decideGameStatus(input);
            return;
        }
        strategy.validate(input);
        List<Integer> actual = parseInput(input);
        defense(actual);
    }

    public void success() {
        state = GameState.PAUSED;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void stop() {
        if(!isRunning()) {
            throw new IllegalStateException("게임이 시작되지 않았습니다.");
        }
        state = GameState.STOPPED;
        System.out.println("게임을 종료합니다.");
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

    private List<Integer> parseInput(String input) {
        List<Integer> numbers = new LinkedList<>();
        for (char c : input.toCharArray()) {
            numbers.add(c - '0');
        }
        return numbers;
    }

    private void defense(List<Integer> actual) {
        DefenseResult result = defenseResultMatcher.match(answers, actual);
        System.out.println(result);
        if(result.isStrikeOut()) {
            success();
            return;
        }
        System.out.print("숫자를 입력해 주세요 : ");
    }

    private void decideGameStatus(String input) {
        switch (input) {
            case "1" -> {
                state = GameState.READY;
                run();
            }
            case "2" -> stop();
            default -> throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
    }
}

package BaseballGame;

import java.util.List;

public class GameManager {
    private NumberGenerator numberGenerator = new NumberGenerator();
    private InputManager inputManager = new InputManager();
    private ScoreEvaluator scoreEvaluator = new ScoreEvaluator();

    public void start() {
        try {
            boolean playAgain = true;
            while (playAgain) {
                doBaseballGame();
                playAgain = askForNewGame();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            inputManager.closeScanner();
        }
    }

    private void doBaseballGame() {
        String answer = numberGenerator.generateNumber();
        boolean status = true;

        while (status) {
            List<String> guess = inputManager.getValidInput();
            List<Integer> result = scoreEvaluator.getScore(guess, answer);

            if (result.get(0) == 0 && result.get(1) == 0) {
                System.out.println("낫싱");
            } else if (result.get(0) == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                status = false;
            } else {
                System.out.printf("%d볼 %d스트라이크%n", result.get(1), result.get(0));
            }
        }
    }

    private boolean askForNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = inputManager.getUserChoice();
        return input == 1;
    }
}

package baseball.game;

import baseball.domain.GameRules;
import baseball.domain.NumberGenerator;
import baseball.view.GameView;

public class Game {
    private GameView gameView;
    private NumberGenerator numberGenerator;
    private GameRules gameRules;
    private String computerNumber;

    public Game() {
        this.gameView = new GameView();
        this.numberGenerator = new NumberGenerator();
        this.gameRules = new GameRules();
        this.computerNumber = numberGenerator.generateNumber();
    }

    public void startGame() {
        boolean gameContinues = true;
        try {
            while (gameContinues) {
                gameContinues = game();
            }
        } catch (IllegalArgumentException e) {
            gameView.displayError(e.getMessage());
        }
    }

    private boolean game() {
        String userGuess = gameView.promptForGuess();
        if (!InputValidator.isValidInput(userGuess)) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
        String result = gameRules.generateHint(computerNumber, userGuess);
        gameView.displayResult(result);
        if (result.equals("3스트라이크")) {
            gameView.displayGameEnd();
            return promptForRestart();
        }
        return true;
    }

    private boolean promptForRestart() {
        while (true) {
            String input = gameView.promptForRestart();
            Boolean decision = gameRules.decideRestart(input);
            if (decision == null) {
                throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
            } else {
                if (decision) {
                    resetGame();
                }
                return decision;
            }
        }
    }

    private void resetGame() {
        computerNumber = numberGenerator.generateNumber();
    }
}

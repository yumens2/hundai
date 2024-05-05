package game;

import java.util.Objects;
import utils.UserInputChecker;
import view.View;

public class Game {

    private static UserInputChecker userInputChecker = null;

    private String answer = null;

    public Game() {
        userInputChecker = UserInputChecker.getUserInputChecker();
    }

    private void setAnswer() {
        answer = (new RandomAnswerGenerator()).getAnswerAsString();
    }

    private boolean isCorrect(int nStrike) {
        return nStrike == GameParameters.nDigit;
    }

    private int[] evaluate(String userGuess) {
        int[] ballAndStrike = new int[2];

        for (int i = 0; i < GameParameters.nDigit; i++) {
            int idx = answer.indexOf(userGuess.charAt(i));
            if (idx == i) {
                ballAndStrike[1]++;
            } else if (idx != -1) {
                ballAndStrike[0]++;
            }
        }
        return ballAndStrike;
    }

    private boolean doNextGame() {
        View.printCorrectAndGameOver();
        String userChoice = View.getUserChoiceForNextGame();
        userInputChecker.isValidChoice(userChoice);

        return Objects.equals(userChoice, GameParameters.nextGame);
    }

    private void runSingleGame() {
        String userGuess;
        while (true) {
            userGuess = View.getUserGuess();
            userInputChecker.isValidGuess(userGuess);
            int[] ballAndStrike = evaluate(userGuess);
            int nBall = ballAndStrike[0];
            int nStrike = ballAndStrike[1];
            View.printResult(nBall, nStrike);

            if (isCorrect(nStrike)) {
                break;
            }
        }
    }

    public void run() {
        boolean continueGame = true;
        while (continueGame) {
            setAnswer();
            System.out.println(answer);
            runSingleGame();
            continueGame = doNextGame();
        }
    }
}

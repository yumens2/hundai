package game;

import utils.UserInputChecker;
import view.View;

public class Game {

    private static UserInputChecker userInputChecker = null;
    private RandomAnswerGenerator randomAnswerGenerator = null;

    private String answer = null;

    public Game() {
        userInputChecker = new UserInputChecker();
        randomAnswerGenerator = new RandomAnswerGenerator();
        answer = randomAnswerGenerator.getAnswerAsString();
        System.out.println(answer);
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

    public void run() {
        String userGuess;
        boolean correct = false;
        while (true) {
            userGuess = View.getUserGuess();
            try {
                UserInputChecker.isValidGuess(userGuess);
            } catch (IllegalArgumentException e) {
                throw e;
            }
            int[] ballAndStrike = evaluate(userGuess);
            View.printResult(ballAndStrike[0], ballAndStrike[1]);
        }
    }


}

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

    public int run() {
        while(true) {
            String userGuess;
            boolean correct = false;
            userGuess = View.getUserGuess();
            try {
                UserInputChecker.isValidGuess(userGuess);
            } catch (IllegalArgumentException e) {
                throw e;
            }

        }
    }


}

package utils;

import game.Game;
import game.GameParameters;
import java.util.Objects;

public class UserInputChecker {

    private static UserInputChecker userInputChecker = null;

    private UserInputChecker() {

    }

    public static UserInputChecker getUserInputChecker() {
        if (userInputChecker == null) {
            userInputChecker = new UserInputChecker();
        }
        return userInputChecker;
    }

    public void isValidGuess(String userGuess) throws IllegalArgumentException {
        if (userGuess.length() != GameParameters.nDigit) {
            throw new IllegalArgumentException();
        }
        char ch;
        for (int i = 0; i < GameParameters.nDigit; i++) {
            ch = userGuess.charAt(i);
            if (!Character.isDigit(ch) || ch == '0') {
                throw new IllegalArgumentException();
            }
        }
    }

    public void isValidChoice(String userChoice) {
        if (Objects.equals(userChoice, GameParameters.nextGame)) {
            return;
        }
        if (Objects.equals(userChoice, GameParameters.quitGame)) {
            return;
        }
        throw new IllegalArgumentException();
    }
}

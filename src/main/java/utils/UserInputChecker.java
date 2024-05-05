package utils;

import game.Game;
import game.GameParameters;
import java.util.Objects;

public class UserInputChecker {

    public UserInputChecker() {

    }

    public static void isValidGuess(String userGuess) throws IllegalArgumentException {
        if (userGuess.length() != GameParameters.nDigit) {
            // return false;
            throw new IllegalArgumentException("자릿수를 확인하세요 input = " + userGuess);
        }

        for (int i = 0; i < GameParameters.nDigit; i++) {
            if (!Character.isDigit(userGuess.charAt(i))) {
                // return false;
                throw new IllegalArgumentException("정수만 입력해주세요 input = " + userGuess);
            }
        }

        //return true;
    }

    public static void isValidChoice(String userChoice) {
        if (Objects.equals(userChoice, GameParameters.nextGame)) {
            return;
        }
        if (Objects.equals(userChoice, GameParameters.quitGame)) {
            return;
        }
        throw new IllegalArgumentException();
    }
}

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

    /**
     * 유저가 제출한 숫자의 유효성을 검증한다.
     *
     * @param userGuess 유저가 제출한 숫자
     * @throws IllegalArgumentException 유저의 응답이 0이나 숫자가 아닌 문자를 포함하는 경우 또는 자릿수가 틀린 경우
     */
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

    /**
     * 유저가 입력한 선택(새게임 또는 종료)을 검증한다.
     *
     * @param userChoice 유저가 입력한 선택
     * @throws IllegalArgumentException 유저가 옵션에 없는 선택을 한 경우
     */
    public void isValidChoice(String userChoice) throws IllegalArgumentException {
        if (Objects.equals(userChoice, GameParameters.nextGame)) {
            return;
        }
        if (Objects.equals(userChoice, GameParameters.quitGame)) {
            return;
        }
        throw new IllegalArgumentException();
    }
}

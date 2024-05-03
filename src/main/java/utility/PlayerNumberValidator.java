package utility;

public class PlayerNumberValidator extends InputNumberValidator {

    private static final int PLAYER_NUMBER_LENGTH = 3;

    public static void isPlayerNumberCorrect(String playerNumber) throws IllegalArgumentException {
        isStringLengthCorrect(playerNumber, PLAYER_NUMBER_LENGTH);
        isStringNumeric(playerNumber);
        isDifferentDigitNumber(playerNumber);
    }
}

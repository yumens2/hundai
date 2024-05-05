package utility;

public class PlayerNumberValidator extends InputNumberValidator {

    private static final int PLAYER_NUMBER_LENGTH = 3;

    private PlayerNumberValidator() {}

    public static void checkPlayerNumberCorrect(String playerNumber) throws IllegalArgumentException {
        checkStringLengthCorrect(playerNumber, PLAYER_NUMBER_LENGTH);
        checkStringNumeric(playerNumber);
        checkDifferentDigitNumber(playerNumber);
    }
}

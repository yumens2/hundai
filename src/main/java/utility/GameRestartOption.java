package utility;

public class GameRestartOption {

    public static boolean isGameRestart() throws IllegalArgumentException {
        return getRestartNumber().equals("1");
    }

    private static String getRestartNumber() throws IllegalArgumentException {
        String inputNumber = InputStringReceiver.getInputString();
        RestartNumberValidator.isRestartNumberCorrect(inputNumber);
        return inputNumber;
    }
}

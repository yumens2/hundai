package utility;

public class GameRestartOption {

    private static final String GAME_RESTART_NUMBER = "1";

    public static boolean isGameRestart() throws IllegalArgumentException {
        ConsoleMessagePrinter.printGameRestartInputMessage();
        return getRestartNumber().equals(GAME_RESTART_NUMBER);
    }

    private static String getRestartNumber() throws IllegalArgumentException {
        String inputNumber = InputStringReceiver.getInputString();
        RestartNumberValidator.isRestartNumberCorrect(inputNumber);
        return inputNumber;
    }
}

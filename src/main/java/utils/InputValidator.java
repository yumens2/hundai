package utils;

/**
 * 사용자 입력을 검증하는 클래스
 */
public class InputValidator {

    private static final String NUMBER_REGEX = "^[1-9]*$";

    public static boolean isInValidNumber(String input) {
        return !(input.matches(NUMBER_REGEX));
    }

    public static boolean isInValidLength(String input) {
        return input.length() != 3;
    }

    public static boolean isDuplicate(String input) {
        return input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2) || input.charAt(0) == input.charAt(2);
    }

    public static boolean isInvalidRestartState(String input) {
        return !input.equals("1") && !input.equals("2");
    }
}

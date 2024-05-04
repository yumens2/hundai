package Validation;

public class ValidateRestart {
    public static void isValidateRestart(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("[ERROR] 1 또는 2를 입력해주세요!");
        }
    }
}

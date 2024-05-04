package Validation;

public class ValidateInput {
    public static void isValidateInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("[ERROR] 3자리 숫자를 입력해주세요!");
        }

        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 1~9 사이의 숫자만 입력해주세요!");
        }

        if (input.chars().distinct().count() != 3) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 입력해주세요!");
        }
    }
}

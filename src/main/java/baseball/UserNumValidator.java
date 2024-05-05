package baseball;

public class UserNumValidator {
    public boolean isValidInput(String input) throws IllegalArgumentException {
        if (input.length() != 3 || !input.matches("\\d{3}")) {
            throw new IllegalArgumentException("세자리 숫자를 입력해주세요.");
        }
        if (input.contains("0")) {
            throw new IllegalArgumentException("0은 허용되지 않습니다.");
        }
        if (!hasUniqueDigits(input)) {
            throw new IllegalArgumentException("중복은 허용되지 않습니다.");
        }
        return true;
    }

    private boolean hasUniqueDigits(String input) {
        return input.chars().distinct().count() == 3;
    }
}
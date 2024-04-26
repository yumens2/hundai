package error;

public class Validator {
    public static void validateNumberInput(String input) {
        if (input.length() != 3)
            throw new IllegalArgumentException("3자리의 숫자를 입력해 주세요.");
        if (hasDuplicate(input))
            throw new IllegalArgumentException("중복된 숫자는 제외해 주세요.");
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }

    private static boolean hasDuplicate(String input) {
        return input.length() != input.chars().distinct().count();
    }

    public static void validateRestartInput(String input) {
        if (input.equals("1") || input.equals("2"))
            return;
        throw new IllegalArgumentException("1이나 2를 입력해 주세요.");
    }
}

package baseball.exception;

public class RetryException {

    private static final int VALID_LENGTH = 1;

    public void retryValidation(String input) {
        isValidLength(input);
        isValidNumber(input);

    }

    public void isValidNumber(String input) {
        if (!(input.equals("1") || !input.equals("2"))) {
            throw new IllegalArgumentException("1,2 만 입력 가능");
        }

    }

    public void isValidLength(String input) {
        if (input.length() != VALID_LENGTH) {
            throw new IllegalArgumentException("한자리 숫자만 입력 가능");
        }
    }

}

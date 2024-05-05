package com.ktc2.precourse.baseball.validator;


/**
 * Retry를 생성하는 데 필요한 String의 유효성을 확인하는 클래스
 */
public class RetryValidator implements Validator<String> {
    private static final RetryValidator instance = new RetryValidator();

    private RetryValidator() {}

    public static RetryValidator getInstance() {
        return instance;
    }

    @Override
    public boolean isValid(String string) {
        if (string == null) {
            return false;
        }
        if (string.length() != 1) {
            return false;
        }

        return string.matches("[12]");
    }
}

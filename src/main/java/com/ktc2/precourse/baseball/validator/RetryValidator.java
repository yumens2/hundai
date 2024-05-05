package com.ktc2.precourse.baseball.validator;

public class RetryValidator implements Validator<String> {
    private static final RetryValidator instance = new RetryValidator();

    private RetryValidator() {}

    public static RetryValidator getInstance() {
        return instance;
    }

    @Override
    public boolean isValid(String string) {
        if (string.length() != 1) {
            return false;
        }

        return string.matches("[12]");
    }
}

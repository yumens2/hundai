package com.ktc2.precourse.baseball.validator;

public class RetryValidator implements Validator<String> {
    @Override
    public boolean isValid(String string) {
        return false;
    }
}

package com.ktc2.precourse.baseball.validator;

import com.ktc2.precourse.baseball.logic.DuplicateChecker;
import com.ktc2.precourse.baseball.object.Numbers;

public class NumbersValidator implements Validator<String> {
    private static final NumbersValidator instance = new NumbersValidator();

    private NumbersValidator() {}

    public static NumbersValidator getInstance() {
        return instance;
    }

    //모든 문자가 1~9의 숫자로 이뤄지지 않은 경우
    private boolean isNotDigit(String str) {
        return !str.chars().allMatch(s -> Character.isDigit(s) && s != '0');
    }

    private boolean hasDuplicatedDigit(String digits) {
        DuplicateChecker<Character> duplicate = new DuplicateChecker<>();

        for (int i = 0; i < Numbers.LENGTH; i++) {
            if (duplicate.check(digits.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean isValid(String str) {
        if (str == null) {
            return false;
        }
        if (str.length() != Numbers.LENGTH) {
            return false;
        }
        if (isNotDigit(str)) {
            return false;
        }

        //숫자 문자열에 중복된 숫자가 있으면 유효하지 않음.
        return hasDuplicatedDigit(str);
    }
}

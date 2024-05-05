package com.ktc2.precourse.baseball.validator;

import com.ktc2.precourse.baseball.logic.DuplicateChecker;
import com.ktc2.precourse.baseball.object.Numbers;

/**
 * Numbers를 생성하는 데 필요한 String의 유효성을 확인하는 클래스
 */
public class NumbersValidator implements Validator<String> {
    private static final NumbersValidator instance = new NumbersValidator();

    private NumbersValidator() {}

    public static NumbersValidator getInstance() {
        return instance;
    }

    /**
     * str의 모든 문자가 1~9의 숫자로 이뤄졌는 지 확인한다.
     * @param str 확인할 문자열
     * @return 모든 문자가 1~9의 숫자로 이뤄지면 true, 아니면 false
     */
    private boolean isNotDigit(String str) {
        return !str.chars().allMatch(s -> Character.isDigit(s) && s != '0');
    }

    /**
     * 숫자로 이뤄진 digits가 중복되지 않게 구성되었는지 확인한다.
     * @param digits 중복을 확인할 숫자로 이뤄진 문자열
     * @return 중복되었으면 true, 아니면 false 반환
     */
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

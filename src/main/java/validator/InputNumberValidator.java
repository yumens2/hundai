package validator;

import java.util.HashSet;

public class InputNumberValidator {
    private static final char MIN_NUMBER = '1';
    private static final char MAX_NUMBER = '9';
    private static final int VALID_LENGTH = 3;

    private static final String NOT_VALID_LENGTH_MESSAGE = VALID_LENGTH + "자리 숫자를 입력해야합니다.";
    private static final String NOT_VALID_RANGE_MESSAGE = MIN_NUMBER + " ~ " + MAX_NUMBER + " 범위 내의 숫자만 허용됩니다.";
    private static final String NOT_UNIQUE_NUMBER_MESSAGE = "중복되지 않는 숫자들로만 구성되어야합니다.";
    public void validateNumber(String number) {
        checkValidLength(number);
        checkNumbersRange(number);
        checkDuplicateNumber(number);
    }

    private void checkValidLength(String number) {
        if(number.length() != VALID_LENGTH) {
            throw new IllegalArgumentException(NOT_VALID_LENGTH_MESSAGE);
        }
    }

    private void checkNumbersRange(String number) {
        for(char c : number.toCharArray()) {
            if(!(c >= MIN_NUMBER && c <= MAX_NUMBER)) {
                throw new IllegalArgumentException(NOT_VALID_RANGE_MESSAGE);
            }
        }
    }

    private void checkDuplicateNumber(String number) {
        HashSet<Integer> set = new HashSet<>();
        for(char c : number.toCharArray()) {
            int num = c - '0';
            if(set.contains(num)) {
                throw new IllegalArgumentException(NOT_UNIQUE_NUMBER_MESSAGE);
            } else {
                set.add(num);
            }
        }
    }
}
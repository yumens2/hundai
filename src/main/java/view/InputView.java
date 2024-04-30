package view;

import exception.DuplicateNumberException;
import exception.InvalidLengthException;
import exception.NonNumericValueException;
import utils.InputValidator;

/**
 * 사용자 입력을 받는 클래스
 */
public class InputView {

    private static final String ASK_NUMBER = "숫자를 입력해 주세요 : ";

    public static String askNumber() {
        System.out.print(ASK_NUMBER);
        String input = System.console().readLine();

        // validation
        if(InputValidator.isInValidNumber(input)) throw new NonNumericValueException();
        if(InputValidator.isInValidLength(input)) throw new InvalidLengthException();
        if(InputValidator.isDuplicate(input)) throw new DuplicateNumberException();

        return input;
    }

    /**
     * 테스트용 메소드
     * @param testInput
     * @return testInput
     */
    public static String askNumber(String testInput) {
        String input = testInput;
        // validation
        if(InputValidator.isInValidNumber(input)) throw new NonNumericValueException();
        if(InputValidator.isInValidLength(input)) throw new InvalidLengthException();
        if(InputValidator.isDuplicate(input)) throw new DuplicateNumberException();

        return input;
    }

}

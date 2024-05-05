package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    Scanner scanner;
    public static final int DIGIT = 3; // 자리수
    private static final String ASK_INPUT_NUM = "숫자를 입력해 주세요: ";
    private static final String INPUT_ERROR_INT = "입력한 값이 숫자가 아닙니다. ";
    private static final String INPUT_ERROR_BOUND = "1과 2중 값을 입력해주세요. ";

    public InputView() {
        scanner = new Scanner(System.in);
    }

    /**
     * 1. input number
     * 2. validation
     * 3. return number
     */
    public List<Integer> input() {
        System.out.print(ASK_INPUT_NUM);
        String inputValue = scanner.nextLine();
        inputValidation(inputValue);
        return parseToInputList(inputValue);
    }

    /**
     * 두 가지 validation 진행
     * 1. 자리수 확인
     * 2. input type 확인
     */
    public void inputValidation(String inputValue) {
        if (!isValidateDigitCount(inputValue)) {
            throw new IllegalArgumentException("입력한 숫자의 자릿수를 " + DIGIT + "자리 수로 입력해주세요.");
        }
        if (!isValidateInt(inputValue)) {
            throw new IllegalArgumentException(INPUT_ERROR_INT);
        }
    }

    /**
     * @param inputValue: input() 메소드에서 Scanner로 받은 값
     * @return 자리 수 확인 후 true/false
     */
    public boolean isValidateDigitCount(String inputValue) {
        int digitCount = String.valueOf(inputValue).length();
        return digitCount == DIGIT;
    }

    /**
     * @param inputValue: input() 메소드에서 Scanner로 받은 값
     * @return int 확인 후 true/false
     */
    public boolean isValidateInt(String inputValue) {
        try {
            Integer.parseInt(String.valueOf(inputValue));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * List로 변환하는 메소드
     * @param inputValue int
     * @return List<Integer>
     */
    public List<Integer> parseToInputList(String inputValue) {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i<DIGIT; i++) {
            char digitChar = inputValue.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            intList.add(digit);
        }
        return intList;
    }

    /**
     * 게임 다시 할건지 사용자로 부터 답을 받는 메소드
     * @return true/false
     */
    public boolean isReplay() {
        String inputValue = scanner.nextLine();

        if (!isValidateInt(inputValue)) {
            throw new IllegalArgumentException(INPUT_ERROR_INT);
        }
        int isReplay = Integer.parseInt(inputValue);
        if (isReplay == 1) {
            return true;
        } else if (isReplay == 2) {
            return false;
        } else {
            throw new IllegalArgumentException(INPUT_ERROR_BOUND);
        }
    }

}

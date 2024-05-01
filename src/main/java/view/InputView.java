package view;

import exception.DuplicateNumberException;
import exception.InvalidLengthException;
import exception.InvalidRestartStateException;
import exception.NonNumericValueException;
import utils.InputValidator;

import java.util.Scanner;

/**
 * 사용자 입력을 받는 클래스
 */
public class InputView {

    private static final String ASK_NUMBER = "숫자를 입력해 주세요 : ";
    private static final String ASK_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static Scanner scanner = new Scanner(System.in);

    public static void setScanner(Scanner scanner) {
        InputView.scanner = scanner;
    }

    /**
     * 사용자로부터 숫자를 입력받고 해당 값이 valid한 지 검증하는 메소드
     *
     * @throws NonNumericValueException
     * @throws InvalidLengthException
     * @throws DuplicateNumberException
     *
     * @return inputString
     */
    public static String askNumber() {
        System.out.print(ASK_NUMBER);
        String input = scanner.nextLine();

        // validation
        if(InputValidator.isInValidNumber(input)) throw new NonNumericValueException();
        if(InputValidator.isInValidLength(input)) throw new InvalidLengthException();
        if(InputValidator.isDuplicate(input)) throw new DuplicateNumberException();

        return input;
    }

    /**
     * 사용자로부터 게임 재시작 여부를 입력받는 메소드
     *
     * @throws InvalidRestartStateException
     *
     * @return isRestart
     */
    public static boolean askRestart() {
        System.out.println(ASK_RESTART);
        String input = scanner.nextLine();

        if(InputValidator.isInvalidRestartState(input)) throw new InvalidRestartStateException();

        if(input.equals("1")) return true;
        return false;
    }
}

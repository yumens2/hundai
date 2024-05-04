package view;

import java.util.Scanner;
import validator.InputNumberValidator;

public class InputView {
    public static final String INPUT_PLAYER_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";

    private final Scanner scanner = new Scanner(System.in);
    private final InputNumberValidator inputNumberValidator = new InputNumberValidator();

    public String inputPlayerNumber() {
        System.out.print(INPUT_PLAYER_NUMBER_MESSAGE);
        String number = scanner.nextLine();
        inputNumberValidator.validateNumber(number);
        return number;
    }
}
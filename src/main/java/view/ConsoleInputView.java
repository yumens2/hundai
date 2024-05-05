package view;

import java.util.Scanner;
import validator.InputValidator;

public class ConsoleInputView implements InputView {

    public static final String INPUT_PLAYER_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";
    public static final String INPUT_RESTART_OR_NOT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final Scanner scanner = new Scanner(System.in);
    private final InputValidator inputValidator = new InputValidator();

    @Override
    public String inputPlayerNumber() {
        System.out.print(INPUT_PLAYER_NUMBER_MESSAGE);
        String number = scanner.nextLine();
        inputValidator.validateNumber(number);
        return number;
    }

    @Override
    public String inputGameMenu() {
        System.out.println(INPUT_RESTART_OR_NOT_MESSAGE);
        String menuCode = scanner.nextLine();
        inputValidator.validateGameMenuCode(menuCode);
        return menuCode;
    }
}
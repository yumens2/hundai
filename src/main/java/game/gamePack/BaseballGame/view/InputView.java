package game.gamePack.BaseballGame.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String GUESS_MESSAGE = "숫자를 입력해주세요 : ";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputRestart() {
        System.out.println(INPUT_RESTART_MESSAGE);
        return scanner.nextLine();
    }

    public static String printGuessMessage() {
        System.out.println(GUESS_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputNumbers() {
        System.out.println(INPUT_NUMBERS_MESSAGE);
        return scanner.nextLine();
    }
}

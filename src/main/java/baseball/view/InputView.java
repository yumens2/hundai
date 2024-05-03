package baseball.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static String printGameStart() {
        System.out.print("숫자를 입력해 주세요 : ");
        return scanner.nextLine();
    }

    public static String printRestartRequest() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextLine();
    }
}

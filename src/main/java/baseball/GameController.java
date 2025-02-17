package baseball;

import java.util.Scanner;

public class GameController {
    private Scanner scanner = new Scanner(System.in);

    public boolean promptForRestart() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        String choice = scanner.nextLine();
        return "1".equals(choice);
    }

    public String getUserInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        return scanner.nextLine();
    }
}
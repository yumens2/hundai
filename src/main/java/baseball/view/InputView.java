package baseball.view;

import java.util.Scanner;

public class InputView {
    public static String startInput(){
        System.out.print("숫자를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static String endInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}

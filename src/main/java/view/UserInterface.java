package view;

import java.util.Scanner;

public class UserInterface {
    private static final String THREE_STRIKE = "3스트라이크";
    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public static void printStartingGame() {
        System.out.println("=============== 숫자 야구 ================");
    }

    public static void printEndingGame() {
        System.out.println("=============== 게임 종료 ================");
    }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}

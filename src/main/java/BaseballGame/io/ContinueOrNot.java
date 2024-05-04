package io;

import Validation.ValidateRestart;

import java.util.Scanner;

public class ContinueOrNot {

    public static boolean isContinueGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();

        ValidateRestart.isValidateRestart(input);

        if (input.equals("1")) {
            return true;
        } else {
            return false;
        }
    }
}

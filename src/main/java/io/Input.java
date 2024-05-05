package io;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static int[] getInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = scanner.nextLine();

        // 입력된 문자열 확인하여 exception 발생시킬지 결정
        if (!input.matches("[0-9]{3}")) {
            throw new IllegalArgumentException("숫자 3개를 입력해야 합니다.");
        }

        int[] guess = new int[3];

        guess[0] = Character.getNumericValue(input.charAt(0));
        guess[1] = Character.getNumericValue(input.charAt(1));
        guess[2] = Character.getNumericValue(input.charAt(2));

        return guess;
    }

    public static int getNewGame() {
        int input;
        do {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            input = scanner.nextInt();
            scanner.nextLine();
            if (input != 1 && input != 2) {
                throw new IllegalArgumentException("잘못된 입력입니다. 1 또는 2를 입력하세요.");
            }
        } while (input != 1 && input != 2);

        return input;
    }
}

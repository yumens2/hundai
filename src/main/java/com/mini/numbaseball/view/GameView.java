package com.mini.numbaseball.view;

import java.util.Scanner;

public class GameView {

    public int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해 주세요 : ");

        return Integer.parseInt(scanner.nextLine());
    }

}

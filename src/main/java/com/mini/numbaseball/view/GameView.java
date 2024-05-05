package com.mini.numbaseball.view;

import java.util.Scanner;

public class GameView {

    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");

        return scanner.nextLine();
    }

    public String getIsReplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return scanner.nextLine();
    }

    public void displayResult(String result) {
        System.out.println(result);
    }

    public void displayException(IllegalArgumentException e){
        System.out.println(e.toString());
    }

    public void displayEnd(){
        System.out.println("프로그램을 종료합니다.");
    }
}

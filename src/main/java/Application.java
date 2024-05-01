package main.java;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game game = new Game();
        Answer answer = new Answer();
        int answerNumber = answer.answerNum();
        int myNumber;

        while(true) {
            int check = 0;
            System.out.print("숫자를 입력해 주세요 : ");
            myNumber = sc.nextInt();
            game.inputNumber(myNumber);
            game.checking(answerNumber);
            if (game.answer()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                check = sc.nextInt();
            }
            if(check == 0)
                continue;
            else if (check == 1) {
                answer = new Answer();
                answerNumber = answer.answerNum();
            }
            else if (check == 2) {
                System.out.println("게임을 종료합니다!");
                break;
            }
            else{
                throw new IllegalArgumentException("1이나 2의 값을 출력해야 합니다");
            }
        }
    }
}

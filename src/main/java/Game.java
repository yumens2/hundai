package main.java;

import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    private int[] num;
    private int strike;
    private int ball;
    public void inputNumber(int number) {
        this.num = new int[3];
        if(number / 100 == 0 || number / 1000 != 0)
            throw new IllegalArgumentException("자리수가 3이 아닙니다");
        this.num[0] = number / 100;
        this.num[1] = number % 100 / 10;
        this.num[2] = number % 10;
    }
    public void checking(int randnum) {
        strike = ball = 0;
        int[] number = new int[3];
        number[0] = randnum / 100;
        number[1] = randnum % 100 / 10;
        number[2] = randnum % 10;

        // checking Strike
        for (int i = 0; i < 3; i++) {
            if (number[i] == num[i])
                strike += 1;
        }

        // checking Ball
        for (int i = 0; i < 3; i++) {
            if(number[i] == num[0] && i != 0)
                ball += 1;
        }
        for (int i = 0; i < 3; i++) {
            if(number[i] == num[1] && i != 1)
                ball += 1;
        }
        for (int i = 0; i < 3; i++) {
            if(number[i] == num[2] && i != 2)
                ball += 1;
        }
    }

    public boolean answer(){
        if(strike != 0 && ball != 0)
            System.out.println(ball + "볼 " + strike + "스트라이크");
        else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼 ");
        }
        else if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        else{
            System.out.println("낫싱");
        }

        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}

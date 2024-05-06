package io;

public class Output {
    public static void printOutput(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크");
        } else if (strike > 0) {
            if (ball > 0) {
            System.out.println(ball+"볼 "+strike+"스트라이크");
            } else {
                System.out.println(strike+"스트라이크");
            }
        } else if (strike == 0) {
            if (ball > 0) {
                System.out.println(ball+"볼");
            } else {
                System.out.println("낫싱");
            }
        }
    }
}

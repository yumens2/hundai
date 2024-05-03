package io;

import static controller.BaseBallGame.MAX_COUNT;

public class Output {

    public void printResult(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            nothing();
        }
        else {
            hint(ballCount, strikeCount);
            if (strikeCount == MAX_COUNT) {
                correct();
            }
        }
    }

    public void hint(int ballCount, int strikeCount) {
        if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        else if (ballCount != 0) {
            System.out.println(ballCount + "볼");
        }
        else {
            System.out.println(strikeCount + "스트라이크");
        }
    }
    
    public void nothing() {
        System.out.println("낫싱");
    }
    
    public void correct() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}

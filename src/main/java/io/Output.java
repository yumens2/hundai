package io;

import model.Hint;

public class Output {

    private static final String FINISH_PROMPT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void hint(Hint hint) {
        int ballCount = hint.getBallCount();
        int strikeCount = hint.getStrikeCount();

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
        System.out.println(FINISH_PROMPT);
    }
}

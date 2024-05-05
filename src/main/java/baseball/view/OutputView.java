package baseball.view;

import baseball.controller.NumberCompare;

public class OutputView {
    public static final int NUMS_LENGTH = 3;

    private final int BALL_COUNT;
    private final int STRIKE_COUNT;

    public OutputView(NumberCompare set) {
        this.BALL_COUNT = set.BALL_COUNT;
        this.STRIKE_COUNT = set.STRIKE_COUNT;
    }

    public static void printGameComplete() {
        System.out.println(NUMS_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printGameResult() {
        printOnlyBall();
        printOnlyStrike();
        printBallAndStrike();
        printNothing();
    }

    private void printOnlyBall() {
        if (BALL_COUNT != 0 && STRIKE_COUNT == 0) {
            System.out.println(BALL_COUNT + "볼");
        }
    }

    private void printOnlyStrike() {
        if (BALL_COUNT == 0 && STRIKE_COUNT != 0) {
            System.out.println(STRIKE_COUNT + "스트라이크");
        }
    }

    private void printBallAndStrike() {
        if (BALL_COUNT != 0 && STRIKE_COUNT != 0) {
            System.out.println(BALL_COUNT + "볼 " + STRIKE_COUNT + "스트라이크");
        }
    }

    private void printNothing() {
        if (BALL_COUNT == 0 && STRIKE_COUNT == 0) {
            System.out.println("낫싱");
        }
    }
}

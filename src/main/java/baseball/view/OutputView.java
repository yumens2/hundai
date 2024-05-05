package baseball.view;

import baseball.domain.BallCount;

public class OutputView {

    private OutputView() {
    }

    public static void resultMessage(BallCount ballCount) {
        System.out.println(ballCount.getResultMessage());
    }
}

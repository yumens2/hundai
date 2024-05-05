package view;

import model.Hint;

import static view.InputView.DIGIT;

public class OutputView {

    private static final String HINT_STRIKE = "스트라이크";
    private static final String HINT_BALL = "볼 ";
    private static final String HINT_NOTHING = "낫싱";
    private static final String MESSAGE_FINISH = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    private static final String MESSAGE_REPLAY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printResult(Hint hint) {
        StringBuilder result = new StringBuilder();

        int strike = hint.getStrike();
        int ball = hint.getBall();

        if (strike == DIGIT) {
            result.append(MESSAGE_FINISH).append("\n").append(MESSAGE_REPLAY);
        }
        else {
            if (ball > 0) {
                result.append(ball).append(HINT_BALL);
            }
            if (strike > 0) {
                result.append(strike).append(HINT_STRIKE);
            }
            if (ball == 0 && strike == 0) {
                result.append(HINT_NOTHING);
            }
        }

        System.out.println(result);
    }

}

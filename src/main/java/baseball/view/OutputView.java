package baseball.view;

import baseball.model.Hint;

public class OutputView {

    private static final String REQUEST_NUMBER_INPUT = "숫자를 입력해주세요: ";
    private static final String BALL_TEXT = "볼 ";
    private static final String STRIKE_TEXT = "스트라이크";
    private static final String NOTHING_TEXT = "낫싱";
    private static final String GAME_FINISHED_TEXT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void requestNumberInput() {
        System.out.print(REQUEST_NUMBER_INPUT);
    }

    public static void displayResult(Hint hint) {
        StringBuilder result = new StringBuilder();

        int strike = hint.getStrike();
        int ball = hint.getBall();

        if (ball > 0) {
            result.append(ball).append(BALL_TEXT);
        }
        if (strike > 0) {
            result.append(strike).append(STRIKE_TEXT);
        }
        if (strike == 0 && ball == 0) {
            result.append(NOTHING_TEXT);
        }

        System.out.println(result);
    }

    public static void displayGameFinished() {
        System.out.println(GAME_FINISHED_TEXT);
    }

    public static void requestGameRestart() {
        System.out.println(GAME_RESTART_PROMPT);
    }
}

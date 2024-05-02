package baseball.view;

public class OutputView {

    private static final String START = "숫자 야구 게임을 시작합니다.";
    private static final String CLEAR_VIEW = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RETRY_VIEW = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final int STRIKE_INDEX = 0;
    private static final int BALL_INDEX = 1;

    public void clearGame() {
        System.out.println(3 + STRIKE);
        System.out.println(CLEAR_VIEW);
        System.out.println(RETRY_VIEW);
    }

    public void notClearGame(int[] score) {
        int strike = score[STRIKE_INDEX];
        int ball = score[BALL_INDEX];

        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING);
        } else if (strike != 0 && ball == 0) {
            System.out.println(strike + STRIKE);
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball + BALL);
        } else {
            System.out.println(strike + STRIKE + " " + ball + BALL);
        }
    }

    public void retryGame() {

    }

    public void startGame() {
        System.out.println(START);
    }

}

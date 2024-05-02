package game.gamePack.BaseballGame.view;

public class OutputView {

    private static OutputView outputView;
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final int ZERO = 0;

    public static OutputView of() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    private OutputView() {
    }

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printGameClearMessage() {
        System.out.println(GAME_CLEAR_MESSAGE);
    }

    public static void printResult(int strikeCount, int ballCount) {
        if (strikeCount == ZERO && ballCount == ZERO) {
            System.out.println(NOTHING);
            return;
        }
        if (strikeCount > ZERO) {
            System.out.print(strikeCount + STRIKE + " ");
        }
        if (ballCount > ZERO) {
            System.out.print(ballCount + BALL);
        }
        System.out.println();
    }

}

package constant;

public final class MessageConstants {
    public static final String GUESS_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String GUESS_ERROR_MESSAGE = "올바른 숫자를 입력하세요.";
    public static final String GUESS_DUPLICATED_ERROR_MESSAGE = "중복되지 않은 숫자를 입력하세요.";

    public static final String RESULT_STRIKE = "스트라이크";
    public static final String RESULT_BALL = "볼";
    public static final String RESULT_NOTHING = "낫싱";
    public static final String RESULT_CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static final String REPLAY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String REPLAY_ERROR_MESSAGE = "1 또는 2를 입력하세요.";

    private MessageConstants() {
    }
}

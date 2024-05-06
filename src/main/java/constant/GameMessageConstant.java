package constant;

public final class GameMessageConstant {

    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";
    public static final String START_GAME = "숫자 야구 게임을 시작합니다. 제가 생각한 숫자를 맞춰보세요!\n";
    public static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    public static final String GAME_CLEAR = String.format("%d개의 숫자를 정확히 맞히셨습니다! 축하드립니다.",
            GameConstant.NUMBER_COUNT);
    public static final String GAME_RESTART_QUESTION = String.format(
            "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.",
            GameConstant.RESTART_GAME_NUMBER, GameConstant.END_GAME_NUMBER);
    public static final String GAME_END = "게임을 종료합니다.";
}

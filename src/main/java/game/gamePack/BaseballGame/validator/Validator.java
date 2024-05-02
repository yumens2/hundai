package game.gamePack.BaseballGame.validator;

public class Validator {

    private static final String END = "2";
    private static final String RESTART = "1";

    /**
     * 옳바른 숫자 게임 입력값 인지 확인합니다.
     *
     * @param input
     * @return void
     */
    public static void validGuessNumber(String input) {
        validThreeNumber(input);
        validDigit(input);
        validZero(input);
    }

    /**
     * 입력값이 1 또는 2인지 확인 illegalArgumentException을 던집니다.
     *
     * @param input
     * @return void
     */
    public static void validRestart(String input) {
        if (!input.equals(RESTART) && !input.equals(END)) {
            throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        }
    }

    /**
     * 입력값이 3자리 숫자인지 확인 illegalArgumentException을 던집니다.
     *
     * @param input
     * @return void
     */
    public static void validThreeNumber(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자만 입력 가능합니다.");
        }
    }

    /**
     * 입력값이 숫자인지 확인 illegalArgumentException을 던집니다.
     *
     * @param input
     * @return void
     */
    public static void validDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    /**
     * 입력값에 0이 있는지 확인 illegalArgumentException을 던집니다.
     *
     * @param input
     * @return void
     */
    public static void validZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
    }

}

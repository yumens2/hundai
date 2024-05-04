public class GameNumber {
    private final String gameNumber;

    public static boolean isValid(String gameNumber) {
        int digitKindCnt = 0;

        if (gameNumber.length() != 3)
            return false;

        for (int i = 0; i < gameNumber.length(); i++) {
            char digit = gameNumber.charAt(i);

            if (digit < '0' || '9' < digit) {
                return false;
            }

            if (gameNumber.indexOf(digit) == i) {
                digitKindCnt++;
            }
        }
        return digitKindCnt == 3;
    }

    GameNumber(String gameNumber) {
        if (!isValid(gameNumber))
            throw new IllegalArgumentException("유효하지 않은 게임 숫자입니다.\n유효한 수 : 중복되지 않는 세 자리 숫자");

        this.gameNumber = gameNumber;
    }
}

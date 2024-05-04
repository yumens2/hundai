public class GameNumber {

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
}

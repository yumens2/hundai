public class CountNum {

    private CountNum() {

    }

    public static String CountSB(String user, String comp) {
        int strike = CountNum.CountS(user, comp);
        int ball = CountNum.CountB(user, comp);
        return strike + Integer.toString(ball);
    }

    public static int CountS(String user, String comp) {
        int cnt = 0;
        char[] userArr = user.toCharArray();
        char[] compArr = comp.toCharArray();

        for (int i = 0; i < userArr.length; i++) {
            if (userArr[i] == compArr[i]) {
                cnt += 1;
            }
        }
        return cnt;
    }

    public static int CountB(String user, String comp) {
        int cnt = 0;
        char[] userArr = user.toCharArray();
        char[] compArr = comp.toCharArray();

        for (int i = 0; i < userArr.length; i++) {
            if (comp.contains(Character.toString(userArr[i]))) {
                cnt += 1;
            }
            if (compArr[i] == userArr[i]) {
                cnt -= 1;
            }
        }
        return cnt;
    }
}

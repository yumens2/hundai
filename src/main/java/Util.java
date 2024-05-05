public class Util {

    public static int countBall(String computer, String user) {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            if ((computer.charAt(i) != user.charAt(i)) && computer.contains(user.substring(i, i + 1))) {
                cnt++;
            }
        }

        return cnt;
    }

    public static int countStrike(String computer, String user) {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.charAt(i) == user.charAt(i)) {
                cnt++;
            }
        }

        return cnt;
    }
}

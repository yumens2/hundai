public class Util {

    /**
     * 볼 개수를 세는 함수이다.
     *
     * @param computer - 컴퓨터가 정한 수
     * @param user     - 사용자가 입력한 수
     * @return 볼 개수
     */
    public static int countBall(String computer, String user) {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            if ((computer.charAt(i) != user.charAt(i)) && computer.contains(
                user.substring(i, i + 1))) {
                cnt++;
            }
        }

        return cnt;
    }

    /**
     * 스트라이크 개수를 세는 함수이다.
     *
     * @param computer - 컴퓨터가 정한 수
     * @param user     - 사용자가 입력한 수
     * @return 스트라이크 개수
     */
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

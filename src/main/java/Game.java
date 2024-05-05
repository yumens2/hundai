public class Game {

    public void start() {
        while (playOnce()) {
            IO.outEnd();                // 종료 문구 출력
            String input = IO.in();     // 종료 옵션 입력

            // 유효하지 않은 값이거나 2(종료)를 입력하면 종료
            if (!Validation.isValidEnd(input) || input.equals("2")) {
                break;
            }
        }
    }

    /**
     * 게임 한 회차에 해당하는 함수이다.
     *
     * @return 3스트라이크로 끝나면 true, 도중에 에러가 발생하면 false
     */
    public boolean playOnce() {
        // 컴퓨터가 랜덤으로 정한 3자리의 수
        InitNumbers initNumbers = new InitNumbers();
        String computer = initNumbers.getNumbers();

        while (true) {
            IO.outProgress();           // 진행 문구 출력
            String user = IO.in();      // 사용자 수 입력

            // 유효하지 않은 수이면 게임 종료
            if (!Validation.isValidNum(user)) {
                return false;
            }

            // 볼, 스트라이크 개수 출력
            int ballCnt = Util.countBall(computer, user), strikeCnt = Util.countStrike(computer, user);
            IO.outResult(ballCnt, strikeCnt);

            // 3스트라이크이면 게임 종료
            if (strikeCnt == 3) {
                return true;
            }
        }
    }
}

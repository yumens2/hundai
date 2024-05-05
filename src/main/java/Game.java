public class Game {

    public void start() {
        while (playOnce()) {
            IO.outEnd();
            String input = IO.in();
            if (!Validation.isValidEnd(input) || input.equals("2")) {
                break;
            }
        }
    }

    public boolean playOnce() {
        InitNumbers initNumbers = new InitNumbers();
        String computer = initNumbers.getNumbers();

        while (true) {
            IO.outProgress();
            String user = IO.in();
            if (!Validation.isValidNum(user)) {
                return false;
            }

            int ballCnt = Util.countBall(computer, user), strikeCnt = Util.countStrike(computer, user);
            IO.outResult(ballCnt, strikeCnt);

            if (strikeCnt == 3) {
                return true;
            }
        }
    }
}

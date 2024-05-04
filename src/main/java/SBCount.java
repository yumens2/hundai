public class SBCount {
    private final int STRIKE;
    private final int BALL;
    private static final int NUMOFDIGIT = 3;

    SBCount(int strike, int ball) {
        this.STRIKE = strike;
        this.BALL = ball;
    }

    @Override
    public String toString() {
        String msg = "";

        if (BALL > 0) {
            msg += BALL + "볼 ";
        }

        if (STRIKE > 0) {
            msg += STRIKE + "스트라이크";
        }

        return msg;
    }

    public boolean isAllStrike() {
        return STRIKE == NUMOFDIGIT;
    }
}

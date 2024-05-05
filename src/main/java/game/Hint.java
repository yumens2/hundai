package game;

public class Hint {
    private static final String NOTHING = "낫싱";
    private static final String STRIKE3 = "3스트라이크";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String SPACE = " ";

    private int strike;
    private int ball;

    public Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean is3Strike() {
        return strike == 3;
    }

    @Override
    public String toString() {
        if(strike == 0 && ball == 0) {
            return NOTHING;
        } else if(strike == 3) {
            return STRIKE3;
        } else {
            String hint = "";
            if(ball > 0) {
                hint += ball + BALL + SPACE;
            }
            if(strike > 0) {
                hint += strike + STRIKE;
            }
            return hint;
        }
    }
}
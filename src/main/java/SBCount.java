public class SBCount {
    private int strike;
    private int ball;

    @Override
    public String toString() {
        String msg = "";

        if (ball > 0) {
            msg += ball + "볼 ";
        }

        if (strike > 0) {
            msg += strike + "스트라이크";
        }

        return msg;
    }
}

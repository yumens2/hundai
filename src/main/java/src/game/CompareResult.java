package src.game;

public class CompareResult {

    private final int strikes;
    private final int balls;

    public CompareResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public void printResult() {
        String resultStr = "";
        if (balls > 0) {
            resultStr += String.format("%d볼 ", balls);
        }

        if (strikes > 0) {
            resultStr += String.format("%d스트라이크", strikes);
        }

        if (balls + strikes == 0) {
            resultStr = "낫싱";
        }

        System.out.println(resultStr);
    }

    public boolean isCorrect() {
        return strikes == 3;
    }
}

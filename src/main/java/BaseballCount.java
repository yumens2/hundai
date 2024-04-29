public class BaseballCount {

    private int ballCount;
    private int strikeCount;

    public void setBaseballCount(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isNothingCount() {
        return ballCount == 0 && strikeCount == 0;
    }
}

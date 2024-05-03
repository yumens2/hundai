package model;

public class Hint {

    private static int ballCount = 0;
    private static int strikeCount = 0;

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void increaseBallCount() {
        ballCount++;
    }

    public void increaseStrikeCount() {
        strikeCount++;
    }
}

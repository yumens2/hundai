package model;

public class Hint {

    private int ballCount = 0;
    private int strikeCount = 0;

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

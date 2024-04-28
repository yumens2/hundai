package baseball;

public class GameResult {
    private int ballCount;
    private int strikeCount;

    public GameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (ballCount != 0)
            stringBuilder.append(ballCount).append("볼 ");

        if (strikeCount != 0)
            stringBuilder.append(strikeCount).append("스트라이크");

        return stringBuilder.toString();
    }
}

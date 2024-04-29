package baseball;

public class GameResult {
    private final int ballCount;
    private final int strikeCount;

    public GameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public boolean isCorrect() {
        return strikeCount == 3;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (ballCount != 0)
            stringBuilder.append(ballCount).append("볼 ");

        if (strikeCount != 0)
            stringBuilder.append(strikeCount).append("스트라이크");

        if (ballCount == 0 && strikeCount == 0)
            stringBuilder.append("낫싱");

        return stringBuilder.toString();
    }
}

package baseball;

public class Game {
    private User user;
    private Computer computer;

    public Game(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
    }

    private GameResult getGameResult(String guessNum, String answer) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < guessNum.length(); ++i) {
            if (isStrike(guessNum, answer, i))
                ++strikeCount;
            if (getBallCount(guessNum, answer, i))
                ++ballCount;
        }

        return new GameResult(ballCount, strikeCount);
    }

    private boolean isStrike(String guessNum, String answer, int i) {
        return guessNum.charAt(i) == answer.charAt(i);
    }

    private boolean getBallCount(String guessNum, String answer, int i) {
        for (int j = 0; j < guessNum.length(); ++j) {
            if (i != j && guessNum.charAt(i) == answer.charAt(j))
                return true;
        }
        return false;
    }
}

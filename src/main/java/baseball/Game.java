package baseball;

public class Game {
    private User user;
    private Computer computer;
    private int answer;
    private

    public Game(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
        this.answer = computer.getProblemNum();
    }

    private GameResult getGameResult() {
        int guessNum = user.makeGuess();
        int ballCount = calculateBall(guessNum, answer);
    }

    private int calculateBall(String guessNum, String answer) {
        int ballCount = 0;
        for (int i = 0; i < guessNum.length(); i++) {

        }
    }
}

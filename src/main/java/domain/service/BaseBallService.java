package domain.service;

import domain.Player;
import domain.Score;
import domain.wrapper.Ball;
import domain.wrapper.Strike;
import java.util.stream.IntStream;

public class BaseBallService {

    private final String randomNumber;

    public BaseBallService(String randomNumber) {
        this.randomNumber = randomNumber;
    }

    public Score startOneGame(Player player) {
        Strike strike = checkStrike(player.getPlayerAnswer());
        Ball ball = checkBall(player.getPlayerAnswer());
        return Score.create(strike, ball);
    }

    private Strike checkStrike(String playerAnswer) {
        int strikes = (int) IntStream.range(0, randomNumber.length())
                .filter(i -> randomNumber.charAt(i) == playerAnswer.charAt(i))
                .count();

        return new Strike(strikes);
    }

    private Ball checkBall(String playerAnswer) {
        int balls = (int) IntStream.range(0, randomNumber.length())
                .filter(i -> randomNumber.indexOf(playerAnswer.charAt(i)) != -1 &&
                        randomNumber.charAt(i) != playerAnswer.charAt(i))
                .count();

        return new Ball(balls);
    }

    public boolean checkGameEnd(Player player) {
        if (randomNumber.equals(player.getPlayerAnswer())) {
            return true;
        }
        return false;
    }
}

package domain;

import infra.IOHandler;
import java.util.ArrayList;

public class BaseballGame {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int NUMBER_SIZE = 3;

    private final Player computerPlayer = new ComputerPlayer();
    private final Player humanPlayer = new HumanPlayer();

    private final IOHandler ioHandler = new IOHandler();

    private int strikes = 0;
    private int balls = 0;


    public void start() {
        computerPlayer.generateNumbers();

        while (!isEnd()) {
            ioHandler.print(Message.INPUT_NUMBER.getMessage());
            humanPlayer.generateNumbers();
            compareNumbers(humanPlayer.getNumbers(), computerPlayer.getNumbers());
        }
    }

    public void compareNumbers(ArrayList<Integer> humanNumbers, ArrayList<Integer> computerNumbers) {
        for (int i = 0; i < NUMBER_SIZE; i++) {
            GameResult outcome = comparePosition(i, humanNumbers.get(i), computerNumbers);
            switch (outcome) {
                case STRIKE:
                    strikes++;
                    break;
                case BALL:
                    balls++;
                    break;
                case NONE:
                    break;
            }
        }
    }

    public GameResult comparePosition(Integer index, Integer playerNumber, ArrayList<Integer> computerNumber) {
        if (computerNumber.contains(playerNumber)) {
            if (computerNumber.indexOf(playerNumber) == index) {
                return GameResult.STRIKE;
            }
            return GameResult.BALL;
        }
        return GameResult.NONE;
    }


    private void printResult(int strikes, int balls) {
        setStrikeAndBallZero();
        if (strikes == 0 && balls == 0) {
            ioHandler.print(GameResult.NONE.getMessage());
            return;
        }

        if (strikes > 0) {
            ioHandler.print(GameResult.STRIKE.getMessage(strikes));
        }

        if (balls > 0) {
            ioHandler.print(GameResult.BALL.getMessage(balls));
        }
    }

    public boolean isEnd() {
        // TODO 구현
        return false;
    }

    // 게임이 종료되었을 때의 메시지를 출력하는 메소드
    public void printEndMessage() {
        // TODO 구현
    }

    private void setStrikeAndBallZero() {
        strikes = 0;
        balls = 0;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }
}


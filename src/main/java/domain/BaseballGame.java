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
        boolean isEnd = false;
        computerPlayer.generateNumbers();

        while (!isEnd) {
            ioHandler.print(Message.INPUT_NUMBER.getMessage());
            humanPlayer.generateNumbers();
            compareNumbers(humanPlayer.getNumbers(), computerPlayer.getNumbers());

            printResult(strikes, balls);

            if (strikes == NUMBER_SIZE) {
                printEndMessage();
                isEnd = true;
            }
        }
    }

    public void compareNumbers(ArrayList<Integer> humanNumbers, ArrayList<Integer> computerNumbers) {
        setStrikeAndBallZero();
        for (int i = 0; i < NUMBER_SIZE; i++) {
            GameResult outcome = comparePosition(i, humanNumbers.get(i), computerNumbers);
            switch (outcome) {
                case STRIKE:
                    strikes++;
                    continue;
                case BALL:
                    balls++;
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
        if (strikes == 0 && balls == 0) {
            ioHandler.print(GameResult.NONE.getMessage());
            return;
        }

        if (balls > 0) {
            ioHandler.print(GameResult.BALL.getMessage(balls));
        }

        if (strikes > 0) {
            ioHandler.print(GameResult.STRIKE.getMessage(strikes));
        }

        ioHandler.println("");
    }


    public void printEndMessage() {
        ioHandler.println(Message.GAME_OVER.getMessage(MAX_NUMBER));
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


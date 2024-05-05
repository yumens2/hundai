package application;

import static domain.BaseballGame.MAX_NUMBER;
import static domain.BaseballGame.MIN_NUMBER;

import domain.BaseballGame;
import domain.Message;
import infra.IOHandler;

public class BaseballGameService {

    private final IOHandler ioHandler = new IOHandler();
    private final BaseballGame baseballGame = new BaseballGame();
    boolean isRunning = true;

    public void run() {
        while (isRunning) {
            start();
            askRestart();
        }
    }


    public void askRestart() {
        ioHandler.print(Message.RESTART.getMessage(MIN_NUMBER, MAX_NUMBER));
        String input = ioHandler.getStringInput();

        GameRestartCode gameRestartCode = validateRestartInput(input);

        if (gameRestartCode == GameRestartCode.EXIT) {
            stop();
        }
    }

    private GameRestartCode validateRestartInput(String input) {
        try {
            return GameRestartCode.getGameRestartCode(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(Message.INVALID_INPUT.getMessage());
        }
    }

    public void start() {
        baseballGame.start();
    }

    public void stop() {
        isRunning = false;
    }

    public enum GameRestartCode {
        RESTART("1"),
        EXIT("2");

        private final String number;

        GameRestartCode(String number) {
            this.number = number;
        }

        public static GameRestartCode getGameRestartCode(String number) {
            for (GameRestartCode gameRestartCode : GameRestartCode.values()) {
                if (gameRestartCode.number.equals(number)) {
                    return gameRestartCode;
                }
            }
            throw new IllegalArgumentException(Message.INVALID_INPUT.getMessage());
        }
    }
}

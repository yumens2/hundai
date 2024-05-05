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

        if (gameRestartCode == GameRestartCode.RESTART) {
            stop();
        }
    }

    private GameRestartCode validateRestartInput(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException(Message.INVALID_INPUT.getMessage());
        }
        if (input.equals("1")) {
            return GameRestartCode.RESTART;
        } else {
            return GameRestartCode.EXIT;
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

        GameRestartCode(String restart) {
            this.number = restart;
        }
    }
}

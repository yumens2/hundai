package application;

import domain.BaseballGame;

public class BaseballGameService {

    private final BaseballGame baseballGame = new BaseballGame();
    boolean isRunning = true;

    public void run() {
        while (isRunning) {
            start();
        }
    }

    public void start() {
        baseballGame.start();
    }

    public void stop() {
        isRunning = false;
    }
}

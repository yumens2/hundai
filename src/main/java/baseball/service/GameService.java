package baseball.service;

import baseball.domain.Computer;

public class GameService {

    private static final int RESTART = 1;
    private static final int END = 2;
    private boolean endGame;

    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(int restartOrEnd, Computer computer) {
        if (restartOrEnd == RESTART) {
            computer.setComputerNumber();
        }
        if (restartOrEnd == END) {
            endGame = true;
        }
    }

}

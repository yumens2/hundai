package baseball;

import baseball.system.GameManager;

public class BaseballApplication {

    private static final GameManager gameManager = GameManager.getInstance();
    public static void main(String[] args) {
        gameManager.startGame();
    }
}

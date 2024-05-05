package baseball;

import baseball.controller.BaseballSystem;

public class Application {
    public static void main(String[] args) {
        BaseballSystem game = new BaseballSystem();
        game.runGame();
    }
}

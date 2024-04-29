package baseball;

import baseball.controller.GameController;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        GameController game = new GameController();
        do {
            game.init();
        } while (game.run());
    }
}

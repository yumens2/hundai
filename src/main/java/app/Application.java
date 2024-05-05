package app;

import game.Game;

public class Application {

    public static void main(String[] args) {
        Game game = new Game();
        try {
            game.run();
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException");
        }
    }
}

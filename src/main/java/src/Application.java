package src;

import src.game.Game;
import src.io.Input;

public class Application {

    public static void main(String[] args) {
        new Game(new Input(System.in)).start();
    }
}

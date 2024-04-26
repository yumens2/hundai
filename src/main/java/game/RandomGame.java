package game;

import io.Input;

public class RandomGame implements Game {
    private Input input;

    public RandomGame(Input input) {
        this.input = input;
    }
    @Override
    public void play() {
        String playerNumber = input.getNumberFromPlayer();
    }
}

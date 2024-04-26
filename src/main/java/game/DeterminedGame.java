package game;

import io.Input;

public class DeterminedGame implements Game {
    private Input input;
    public DeterminedGame(Input input, int num) {
        this.input = input;
    }

    @Override
    public void play() {
    }
}

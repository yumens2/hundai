package game;

import io.Input;
import io.Output;

public class DeterminedGame implements Game {
    private Input input;
    private Output output;
    private String computerNumber;
    public DeterminedGame(Input input, Output output, int num) {
        this.input = input;
        this.output = output;
        this.computerNumber = String.valueOf(num);
    }

    @Override
    public void play() {
        while (true) {
            String playerNumber = input.getNumberFromPlayer();

        }
    }
}

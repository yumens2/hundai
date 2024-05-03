package controller;

import io.Input;
import model.RandomNonZeroNumberGenerator;

import java.util.List;

public class BaseBallGame {

    private static final Input input = new Input();
    private static final RandomNonZeroNumberGenerator generator = new RandomNonZeroNumberGenerator();

    public void play() {
        List<Integer> answer = generator.generate();

        String inputString = input.input();
        List<Integer> inputNumbers = input.validateAndParse(inputString);
    }
}

package controller;

import io.Input;
import io.Output;
import model.Hint;
import model.RandomNonZeroNumberGenerator;

import java.util.List;

public class BaseBallGame {

    public static final int MAX_COUNT = 3;

    private static final Input input = new Input();
    private static final Output output = new Output();
    private static final RandomNonZeroNumberGenerator generator = new RandomNonZeroNumberGenerator();

    private Hint hint;

    public void play() {
        do {
            List<Integer> answer = generator.generate();
            playEachRound(answer);
        } while (input.restart() == 1);
    }

    private void playEachRound(List<Integer> answer) {
        while (true) {
            String inputString = input.input();
            List<Integer> inputNumbers = input.validateAndParse(inputString);

            ballStrike(answer, inputNumbers);
            printResult(hint);

            if (hint.getStrikeCount() == MAX_COUNT) {
                output.correct();
                break;
            }
        }
    }

    private void ballStrike(List<Integer> answer, List<Integer> inputNumbers) {
        hint = new Hint();

        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals(inputNumbers.get(i))) {
                hint.increaseStrikeCount();
            }
            else if (inputNumbers.contains(answer.get(i))) {
                hint.increaseBallCount();
            }
        }
    }

    private void printResult(Hint hint) {
        int ballCount = hint.getBallCount();
        int strikeCount = hint.getStrikeCount();

        if (ballCount == 0 && strikeCount == 0) {
            output.nothing();
        }
        else {
            output.hint(hint);
        }
    }
}

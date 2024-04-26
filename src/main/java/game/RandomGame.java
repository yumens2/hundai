package game;

import io.Input;
import io.Output;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomGame implements Game {
    private Input input;
    private Output output;

    public RandomGame(Input input, Output output) {
        this.input = input;
        this.output = output;
    }
    @Override
    public void play() {
        String computerNumber = makeRandomNumber();
        while (true) {
            String playerNumber = input.getNumberFromPlayer();
        }
    }

    private String makeRandomNumber() {
        Set<Integer> set = new HashSet<>();
        StringBuilder result = new StringBuilder();
        while (set.size() != 3)
            set.add(makeRandomNumber(1, 9));
        List<Integer> randomNumber = set.stream().collect(Collectors.toList());
        Collections.shuffle(randomNumber);
        for (int num : randomNumber)
            result.append(num);
        return result.toString();
    }

    private int makeRandomNumber(int start, int end) {
        return (int) (Math.random() * end) + start;
    }
}

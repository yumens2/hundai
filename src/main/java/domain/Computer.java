package domain;

import java.util.List;

public interface Computer {
    List<Integer> generateRandomNumbers();

    String checkStrike(List<Integer> generatedNumbers, String userInputs);
}

package CompareNumber;

import static GenerateRandomNumber.RandomNumberGeneratorConfigure.LENGTH;

import java.util.List;
import java.util.Objects;

public class CompareNumber {

    public static int strike(List<Integer> generatedNumbers, List<Integer> input) {
        int strikeCount = 0;
        for (int i = 0; i < LENGTH.getValue(); i++) {
            if (Objects.equals(generatedNumbers.get(i), input.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public static int ball(List<Integer> generatedNumbers, List<Integer> input) {
        int ballCount = 0;
        for (int i = 0; i < LENGTH.getValue(); i++) {
            if (!Objects.equals(generatedNumbers.get(i), input.get(i)) && generatedNumbers.contains(
                input.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }
}

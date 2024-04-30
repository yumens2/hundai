package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAnswerGenerator implements AnswerGenerator {

    private static final int MAXIMUM_LENGTH_OF_ANSWER = 3;

    private final Random random = new Random();

    @Override
    public List<Integer> generate() {
        final List<Integer> answers = new ArrayList<>();
        while (answers.size() != MAXIMUM_LENGTH_OF_ANSWER) {
            final int randomNumber = random.nextInt(9) + 1;
            if (!answers.contains(randomNumber)) {
                answers.add(randomNumber);
            }
        }
        return answers;
    }
}

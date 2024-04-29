package baseball.test;

import baseball.domain.AnswerGenerator;
import java.util.List;

public class FixedAnswerGenerator implements AnswerGenerator {

    @Override
    public List<Integer> generate() {
        return List.of(1, 4, 2);
    }
}

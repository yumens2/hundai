package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomAnswerGenerator {

    private List<Integer> digits = null;

    public RandomAnswerGenerator() {
        digits = new ArrayList<>(9);
        for (int i = 1; i < 10; i++) {
            digits.add(i);
        }
    }

    public String getAnswerAsString() {
        String answer = "";
        for (int i = 0; i < GameParameters.nDigit; i++) {
            Collections.shuffle(digits);
            int d = digits.remove(digits.size() - 1);
            answer += String.valueOf(d);
        }
        return answer;
    }
}

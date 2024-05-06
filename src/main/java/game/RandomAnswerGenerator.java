package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomAnswerGenerator {

    private List<Integer> digits;

    public RandomAnswerGenerator() {
        digits = new ArrayList<>(9);
        for (int i = 1; i < 10; i++) {
            digits.add(i);
        }
    }

    /**
     * 1~9까지 다른 숫자 3개로 이루어진 정답을 생성한다.
     *
     * @return 랜덤으로 생성된 정답
     */
    public String getAnswerAsString() {
        String answer = "";
        for (int i = 0; i < GameParameters.nDigit; i++) {
            Collections.shuffle(digits);
            int d = digits.remove(digits.size() - 1);
            answer += d;
        }
        return answer;
    }
}

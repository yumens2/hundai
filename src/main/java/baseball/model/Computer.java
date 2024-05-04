package baseball.model;

import baseball.enums.Result;
import java.util.List;
import java.util.Random;

public class Computer {

    private List<Integer> answer;

    public void init() {
        Random random = new Random();

        while (answer.size() < 3) {
            int randomNumber = random.nextInt(9) + 1;
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public String isCorrect(List<Integer> input) {
        int strike = 0, ball = 0;

        for (int i = 0; i < 3; i++) {
            int number = input.get(i);

            if (number == answer.get(i)) {
                strike++;
            } else if (answer.contains(number)) {
                ball++;
            }
        }
        return Result.toString(strike, ball);
    }
}

package baseball.model;

import baseball.dto.ResultDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {

    private List<Integer> answer;

    public void init() {
        answer = new ArrayList<>();

        while (answer.size() < 3) {
            int randomNumber = generateRandomNumber();
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }

    public ResultDto judge(List<Integer> input) {
        int strike = 0, ball = 0;

        for (int i = 0; i < 3; i++) {
            int number = input.get(i);

            if (number == answer.get(i)) {
                strike++;
            } else if (answer.contains(number)) {
                ball++;
            }
        }
        return new ResultDto(strike, ball);
    }
}

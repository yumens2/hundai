package baseball.service;

import baseball.Validator;
import baseball.domain.Ball;
import baseball.domain.BallType;
import baseball.domain.Pitching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DefaultGameService {
    private final Random random = new Random();

    public int getRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.get(0) * 100 + numbers.get(1) * 10 + numbers.get(2);
    }

    public Pitching createPitching(String input, List<Ball> answer) {
        List<Ball> balls = new ArrayList<>();
        Validator.validIsInteger(input);
        int number = Integer.parseInt(input);
        Validator.validDigit(number);
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(BallType.NOTHING, number % 10));
            number /= 10;
        }
        checkBallsType(answer, balls);
        return new Pitching(balls);
    }

    private void checkBallsType(List<Ball> answer, List<Ball> balls) {
        for (int i = 0; i < 3; i++) {
            if ( balls.get(i).getNumber() == answer.get(i).getNumber()) {
                balls.get(i).setBallType(BallType.STRIKE);
            } else if (answer.contains(balls.get(i))) {
                balls.get(i).setBallType(BallType.BALL);
            }
        }
    }
}

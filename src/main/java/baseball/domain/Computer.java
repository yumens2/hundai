package baseball.domain;

import baseball.system.constants.Rule;
import baseball.utils.RandomNumberGenerator;
import java.util.List;

public class Computer {

    private BaseballNumber baseballNumber;

    public Computer() {
        initBaseballNumber();
    }

    public void initBaseballNumber() {
        this.baseballNumber = new BaseballNumber(
            RandomNumberGenerator.getNonDuplicateNumbers(Rule.BASEBALL_NUMBER_SIZE));
    }

    public BallCount calculateBallCount(BaseballNumber userBaseballNumber) {
        int strike = 0;
        int ball = 0;

        List<Integer> userNumbers = userBaseballNumber.getBaseballNumbers();
        for (Integer userNumber : userNumbers) {
            if (baseballNumber.isStrike(userNumber, userNumbers.indexOf(userNumber))) {
                strike++;
            } else if (baseballNumber.isBall(userNumber)) {
                ball++;
            }
        }

        return new BallCount(strike, ball);
    }

}

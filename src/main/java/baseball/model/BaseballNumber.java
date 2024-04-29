package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballNumber {

    private final List<Integer> number;

    public BaseballNumber(List<Integer> number) {
        this.number = number;
    }
    
    public Hint compare(BaseballNumber opponent) {
        int strikes = 0;
        int balls = 0;

        for (int index = 0; index < number.size(); index++) {
            if (isStrike(opponent, index)) {
                strikes++;
            } else if(findBall(opponent, index)){
                balls++;
            }
        }

        return new Hint(strikes, balls);
    }


    private boolean isStrike(BaseballNumber opponent, int index) {
        return number.get(index).equals(opponent.number.get(index));
    }

    private boolean findBall(BaseballNumber opponent, int index) {
        for (int compareIndex = 0; compareIndex < number.size(); compareIndex++) {
            if (index != compareIndex && number.get(index).equals(opponent.number.get(compareIndex))) {
                return true;
            }
        }
        return false;
    }
}

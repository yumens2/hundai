import java.util.*;
public class BaseballNumber {

    public static final int NUMBER_OF_CASE = 3;
    public static final int BALL = 1;
    public static final int NOTBALL = 0;
    private List<Integer> randomNum;
    private List<Integer> userNum;


    BaseballNumber() {
        randomNum = new ArrayList<>();
        userNum = new ArrayList<>();
    }

    public void setUserNum(List<Integer> userNum) {
        this.userNum = userNum;
    }

    public void setRandomNum(List<Integer> randomNum) {
        this.randomNum = randomNum;
    }

    public int countStrike() {
        int cnt = 0;
        for (int i = 0; i < NUMBER_OF_CASE; i++) {
            if (randomNum.get(i) == userNum.get(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int countBall() {
        int cnt = 0;
        for (int i = 0; i < NUMBER_OF_CASE; i++) {
            if (checkBall(i) == BALL) {
                cnt++;
            }
        }
        return cnt;
    }

    public int checkBall(int index) {
        if (randomNum.contains(userNum.get(index))) {
            if (index != randomNum.indexOf(userNum.get(index))) {
                return BALL;
            }
        }
        return NOTBALL;
    }

}

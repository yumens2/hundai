import java.util.*;
public class BaseballNumber {
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

}

import java.util.ArrayList;
import java.util.Objects;

public class BaseballGame {
    public int play(ArrayList<Integer> targetNumbers, ArrayList<Integer> inputNumbers) {
        int strike = 0, ball = 0;
        for (int i = 0; i < targetNumbers.size(); i++) {
            if (Objects.equals(targetNumbers.get(i), inputNumbers.get(i))) {
                strike++;
            } else if (targetNumbers.contains(inputNumbers.get(i))) {
                ball++;
            }
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        }

        return strike;
    }
}

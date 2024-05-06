import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ResultCalculator {
    public String calculateResult(Set<Integer> computerNumbers, String userInput) {
        int strikes = 0;
        int balls = 0;
        List<Integer> computerList = new ArrayList<>(computerNumbers);
        int[] userNumbers = userInput.chars().map(c -> c - '0').toArray();

        for (int i = 0; i < 3; i++) {
            if (userNumbers[i] == computerList.get(i)) {
                strikes++;
            } else if (computerList.contains(userNumbers[i])) {
                balls++;
            }
        }
        
        if (balls > 0 && strikes > 0) {
            return balls + "볼 " + strikes + "스트라이크";
        }
        if (balls > 0) {
            return balls + "볼";
        }
        if (strikes > 0) {
            return strikes + "스트라이크";
        }
        return "낫싱";
    }
}

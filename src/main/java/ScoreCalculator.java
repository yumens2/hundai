package Game;

import java.util.List;

//사용자의 숫자와 컴퓨터의 숫자를 비교해 strike와 ball의 갯수를 알려주는 기능
public class ScoreCalculator {
    public static int[] calculateScore(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                strikes++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                balls++;
            }
        }
        return new int[]{strikes, balls};
    }
}
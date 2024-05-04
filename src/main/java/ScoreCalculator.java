import java.util.List;

public class ScoreCalculator {
    public static int[] calculateScore(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                strike++;
            }
            else if (computerNumbers.contains(userNumbers.get(i))) {
                ball++;
            }
        }
        return new int[]{strike, ball};
    }
}
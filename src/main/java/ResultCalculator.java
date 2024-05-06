import java.util.Set;

public class ResultCalculator {
    public String calculateResult(Set<Integer> computerNumbers, String userInput) {
        int strikes = 0;
        int balls = 0;
        int[] userNumbers = userInput.chars().map(c -> c - '0').toArray();

        Integer[] compNumbersArray = computerNumbers.toArray(new Integer[0]);
        for (int i = 0; i < userNumbers.length; i++) {
            if (compNumbersArray[i].equals(userNumbers[i])) {
                strikes++;
            } else if (computerNumbers.contains(userNumbers[i])) {
                balls++;
            }
        }
        
        if (balls > 0 && strikes > 0) {
            return balls + " 볼 " + strikes + " 스트라이크";
        }
        if (balls > 0) {
            return balls + " 볼";
        }
        if (strikes > 0) {
            return strikes + " 스트라이크";
        }
        return "낫싱";
    }
}

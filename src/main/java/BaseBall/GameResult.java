package BaseBall;
import java.util.List;

public class GameResult {
    public static String calculateResult(List<Integer> computerNumbers, String userGuess) {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            int userNumber = Character.getNumericValue(userGuess.charAt(i));
            if (userNumber == computerNumbers.get(i)) {
                strikes++;
            } else if (computerNumbers.contains(userNumber)) {
                balls++;
            }
        }
        if (strikes == 3) {
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        } else if (strikes == 0 && balls == 0) {
            return "낫싱";
        } else {
            return balls + "볼 " + strikes + "스트라이크";
        }
    }
}

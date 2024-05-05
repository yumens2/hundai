import java.util.List;

public class Compare {
    public static String compareNumbers(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < playerNumbers.size(); i++) {
            int playerNum = playerNumbers.get(i);
            if (computerNumbers.contains(playerNum)) {
                if (computerNumbers.get(i).equals(playerNum)) {
                    strikes++;
                } else {
                    balls++;
                }
            }
        }

        if (strikes == 0 && balls == 0) {
            return "낫싱";
        } else {
            String result = "";
            if (balls > 0) {
                result += balls + "볼 ";
            }
            if (strikes > 0) {
                result += strikes + "스트라이크";
            }
            return result.trim();
        }
    }
}

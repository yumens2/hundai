import java.util.List;

public class Compare {
    public static String getFeedback(List<Integer> computer, List<Integer> player) {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(player.get(i))) {
                strikes++;
            } else if (computer.contains(player.get(i))) {
                balls++;
            }
        }
        if (strikes == 0 && balls == 0) {
            return "낫싱";
        } else if (strikes > 0 && balls > 0) {
            return strikes + " 스트라이크 " + balls + " 볼";
        } else if (strikes > 0) {
            return strikes + " 스트라이크";
        } else {
            return balls + " 볼";
        }
    }
}

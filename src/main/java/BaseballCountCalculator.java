public class BaseballCountCalculator {

    public static int countBall(String playerNumber, String answerNumber) {
        int ballCount = 0;
        for (int i = 0; i < playerNumber.length(); i++) {
            if (answerNumber.contains(Character.toString(playerNumber.charAt(i)))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public static int countStrike(String playerNumber, String answerNumber) {
        int strikeCount = 0;
        for (int i = 0; i < playerNumber.length(); i++) {
            if (answerNumber.indexOf(i) == playerNumber.indexOf(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}

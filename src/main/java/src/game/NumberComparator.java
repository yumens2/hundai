package src.game;

public class NumberComparator {

    public static boolean compareNumber(int answer, int guess) {
        String answerStr = String.valueOf(answer);
        String guessStr = String.valueOf(guess);

        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (answerStr.charAt(i) == guessStr.charAt(i)) {
                strikes++;
            } else if (answerStr.contains(guessStr.substring(i, i + 1))) {
                balls++;
            }
        }

        CompareResult result = new CompareResult(strikes, balls);
        result.printResult();

        return result.isCorrect();
    }
}

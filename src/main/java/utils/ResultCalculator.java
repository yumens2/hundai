package utils;

public class ResultCalculator {
    public static int countStrike(int[] answer, int[] guess) {
        int count = 0;

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == guess[i]) {
                count++;
            }
        }

        return count;
    }

    public static int countNotContain(int[] answer, int[] guess) {
        int count = 0;

        for (int i = 0; i < guess.length; i++) {
            if (!isContain(answer, guess[i])) {
                count++;
            }
        }

        return count;
    }

    private static boolean isContain(int[] arr, int number) {
        for (int num : arr) {
            if (num == number) {
                return true;
            }
        }

        return false;
    }
}

public class IsStrikeBall {
    public static int isStrike(int[] numbers, int[] guess) {
        int str = 0;

        for (int i = 0; i < 3; i++) {
            if (guess[i] == numbers[i]) {
                str++;
            }
        }

        return str;
    }

    public static int isBall(int[] numbers, int[] guess) {
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            balls += checkBall(numbers, guess, i);
        }

        return balls;
    }

    public static int checkBall(int[] numbers, int[] guess, int ind) {
        int ballCnt = 0;
        for (int j = 0; j < 3; j++) {
            if (ind != j && guess[ind] == numbers[j]) {
                ballCnt++;
            }
        }

        return ballCnt;
    }

}

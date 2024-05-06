package utils;

public class resultCalculation {
    public static int countStrikes(int[] gameNumber, int[] userNumber) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (gameNumber[i] == userNumber[i]) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    public static int countBall(int[] gameNumber, int[] userNumber) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            for(int j=0; j<3; j++){
                if (gameNumber[i] == userNumber[i]) {
                    ballCount++;
                }
            }
        }

        return ballCount;
    }

}
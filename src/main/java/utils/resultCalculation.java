package utils;

public class resultCalculation {
    public static int countStrikes(Integer[] gameNumber, Integer[] userNumber) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (gameNumber[i].equals(userNumber[i])) {
                strikeCount++;
            }
        }

        return strikeCount;
}

import java.util.HashSet;
import java.util.Scanner;

public class Utility {

    private Utility() {
    }

    public static int[] makeRandomNumbers() {
        boolean[] flags = new boolean[10];
        int[] randomNumbers = new int[3];
        int count = 0;

        while (count < 3) {
            int temp = (int) (Math.random() * 9) + 1;
            if (flags[temp]) {
                continue;
            } else {
                randomNumbers[count] = temp;
                flags[temp] = true;
                count += 1;
            }
        }

        return randomNumbers;
    }

    public static String getUserString() {
        Scanner sc = new Scanner(System.in);
        String userString = sc.nextLine();

        return userString;
    }

    public static void checkStringLength(String userString) {
        if (userString.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkStringDistinct(String userString) {
        HashSet<Character> tempSet = new HashSet<>();

        for (int i = 0; i < userString.length(); i++) {
            tempSet.add(userString.charAt(i));
        }

        if (tempSet.size() != userString.length()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkStringDigit(String userString) {
        for (int i = 0; i < userString.length(); i++) {
            int temp = (int) userString.charAt(i) - (int) '0';
            if (temp < 1 || temp > 9) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static int[] stringToIntArray(String userString) {
        int[] userNumbers = new int[3];

        for (int i = 0; i < 3; i++) {
            int temp = (int) userString.charAt(i) - (int) '0';
            userNumbers[i] = temp;
        }

        return userNumbers;
    }

    public static int strikeCount(int[] randomNumbers, int[] userNumbers) {
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (randomNumbers[i] == userNumbers[i]) {
                strike += 1;
            }
        }

        return strike;
    }

    public static int ballCount(int[] randomNumbers, int[] userNumbers) {
        int ball = 0;

        if (userNumbers[0] == randomNumbers[1] || userNumbers[0] == randomNumbers[2]) {
            ball += 1;
        }
        if (userNumbers[1] == randomNumbers[0] || userNumbers[1] == randomNumbers[2]) {
            ball += 1;
        }
        if (userNumbers[2] == randomNumbers[0] || userNumbers[2] == randomNumbers[1]) {
            ball += 1;
        }

        return ball;
    }

    public static String getStrikeBall(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        } else if (ball == 0) {
            return strike + "스트라이크";
        } else if (strike == 0) {
            return ball + "볼";
        } else {
            return ball + "볼 " + strike + "스트라이크";
        }
    }
}

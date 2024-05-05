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
            int temp = (int) (Math.random() * 10);
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
        System.out.print("숫자를 입력해 주세요 : ");

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
            if (temp < 0 || temp > 9) {
                throw new IllegalArgumentException();
            }
        }
    }

}

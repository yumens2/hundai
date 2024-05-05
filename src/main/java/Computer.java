import java.util.Random;

public class Computer {
    public static int makeRandom() {
        int[] digits = new int[3];
        Random random = new Random();
        boolean[] used = new boolean[10]; // 사용된 숫자를 추적하기 위한 배열

        for (int i = 0; i < 3; i++) {
            int randomDigit;
            do {
                randomDigit = random.nextInt(9) + 1; // 1부터 9까지의 랜덤 숫자 생성
            } while (used[randomDigit]); // 이미 사용된 숫자인 경우 다시 생성

            digits[i] = randomDigit;
            used[randomDigit] = true;
        }

        int[] digit = digits;
        int number = digit[0] * 100 + digit[1] * 10 + digit[2];

        return number;
    }
}

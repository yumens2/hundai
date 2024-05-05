package start;

import java.security.SecureRandom;

public class RandomThreeNumGenerator {
    public static int[] generateRanNum() {
        // 1부터 9까지의 서로 다른 임의의 수 3개 생성
        int[] num = new int[3];
        int[] count = new int[10];

        SecureRandom ran = new SecureRandom();

        for(int i = 0; i < num.length; ++i) {
            int randomNumber;
            do {
                randomNumber = 1 + ran.nextInt(9);
            } while(count[randomNumber] != 0);

            num[i] = randomNumber;
            count[randomNumber]++;
        }

        for(int i = 0; i < num.length; ++i) {
            System.out.print(num[i]);
        }
        return num;
    }
}

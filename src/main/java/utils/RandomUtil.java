package utils;

import java.util.Random;

public class RandomUtil {

    private static Random random = new Random();

    /**
     * 랜덤한 세 자리를 생성해서 반환하는 함수
     *
     * @return 중복되지 않는 렌덤한 세 자리의 수
     */
    public static int[] getRandomNumbers() {
        int[] numbers = new int[3];

        for (int i = 0; i < 3; i++) {
            numbers[i] = generateUniqueNumber(numbers);
        }

        return numbers;
    }

    /**
     * 유니크한 숫자 생성하기
     *
     * @param numbers 최종 세 자리
     * @return 중복되지 않는 숫자
     */
    private static int generateUniqueNumber(int[] numbers) {
        int num = random.nextInt(10);

        for (int i = 0; i < numbers.length; i++) {
            while (!isUnique(num, numbers[i])) {
                num = random.nextInt(10);
            }
        }

        return num;
    }

    private static boolean isUnique(int num, int compareNum) {
        return num != compareNum;
    }

}

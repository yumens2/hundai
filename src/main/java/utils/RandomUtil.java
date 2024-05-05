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
            numbers[i] = generateUniqueNumber(numbers, i);
        }

        return numbers;
    }

    /**
     * 유니크한 숫자 생성하기
     *
     * @param numbers 최종 세 자리
     * @param idx     현재 인덱스
     * @return 중복되지 않는 숫자
     */
    private static int generateUniqueNumber(int[] numbers, int idx) {
        int num = random.nextInt(9) + 1;

        while (!isUnique(num, numbers, idx)) {
            num = random.nextInt(9) + 1;
        }

        return num;
    }

    /**
     * 현재 생성된 숫자가 이전 숫자들과 중복되는지 확인
     *
     * @param num     생성된 숫자
     * @param numbers 이전 숫자 배열
     * @param idx     현재 인덱스
     * @return 중복 여부
     */
    private static boolean isUnique(int num, int[] numbers, int idx) {
        for (int i = 0; i < idx; i++) {
            if (numbers[i] == num) {
                return false;
            }
        }
        return true;
    }

}

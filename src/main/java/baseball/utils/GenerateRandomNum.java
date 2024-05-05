package baseball.utils;

import java.util.Random;
public class GenerateRandomNum {
    private static final Random random = new Random();
    public static int[] getRandomNumbers(int size, int start, int end) {
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = getUniqueRandomNumber(numbers, start, end, i);
        }
        return numbers;
    }

    private static int getUniqueRandomNumber(int[] numbers, int start, int end, int i) {
        // start와 end 사이의 랜덤 숫자 생성
        int randomNumber = start + random.nextInt(end - start + 1);
        while (!isUnique(numbers, i, randomNumber)) {
            // 랜덤 숫자가 유니크하지 않으면 새로운 랜덤 숫자 생성
            randomNumber = start + random.nextInt(end - start + 1);
        }
        return randomNumber;
    }

    private static Boolean isUnique(int[] numbers, int i, int randomNumber) {
        for (int j = 0; j < i; j++) {
            if (numbers[j] == randomNumber) {
                return false;
            }
        }
        return true;
    }
}
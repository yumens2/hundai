package util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumberUtil {
    public static int[] generateRandomNumber() {
        Set<Integer> generatedNumbers = new HashSet<>();
        Random random = new Random();

        while(generatedNumbers.size() < 3) {
            int randomNumber = random.nextInt(9) + 1;
            generatedNumbers.add(randomNumber);
        }

        int[] numbers = new int[3];
        int index = 0;
        for(int num : generatedNumbers) {
            numbers[index++] = num;
        }

        return numbers;
    }

    public static int[] parseStringToNumbers(String numberString) {
        // 입력값의 길이가 3인지 확인
        if(numberString == null || numberString.length() != 3) {
            throw new IllegalArgumentException("Input Value Error");
        }

        // 입력값이 숫자인지 확인
        if(!numberString.matches("[0-9]+")) {
            throw new IllegalArgumentException("Input Value Error");
        }

        // 입력값을 분리하여 정수 배열에 저장
        int[] numbers = new int[3];
        for(int i = 0; i < 3; i++) {
            numbers[i] = Character.getNumericValue(numberString.charAt(i));
        }

        return numbers;
    }

    public static boolean isDistinctNumbers(int[] numbers) {
        // 입력된 정수 배열의 크기가 3인지, null이 아닌지 확인
        if(numbers.length != 3 || numbers == null) {
            throw new IllegalArgumentException("Array length must be 3");
        }

        Set<Integer> checkedNumbers = new HashSet<>();
        for(int number : numbers) {
            // 범위 안에 있는지 확인
            if(number < 1 || number > 9) {
                return false;
            }

            // 숫자 중복 검사
            if(!checkedNumbers.add(number)) {
                return false;
            }
        }

        return true;
    }
}

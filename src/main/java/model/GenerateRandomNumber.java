package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 1~9 사이의 정수 값 - DIGIT 자리수를 랜덤으로 반환
 * DIGIT 조절로 자리 수 변경
 */
public class GenerateRandomNumber {

    public static final int DIGIT = 3;

    public List<Integer> getRandomNumberList() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < DIGIT; i++) {
            randomNumbers.add(ThreadLocalRandom.current().nextInt(1, 10));
        }
        return randomNumbers;
    }
}

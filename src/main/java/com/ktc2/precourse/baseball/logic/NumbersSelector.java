package com.ktc2.precourse.baseball.logic;

import com.ktc2.precourse.baseball.object.Numbers;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * 중복되지 않은 3개의 숫자를 선택하는 클래스
 */
public class NumbersSelector {
    private static final Random r = new Random();

    /**
     * 랜덤 셔플된 1~9로 이뤄진 숫자 배열을 반환한다.
     * @return 셔플된 숫자 배열
     */
    private static int[] shuffledDigits() {
        int[] ret = IntStream.rangeClosed(1, 9).toArray();

        for (int i = 0; i < ret.length; i++) {
            int randIdx = r.nextInt(ret.length);
            int tmp = ret[i];
            ret[i] = ret[randIdx];
            ret[randIdx] = tmp;
        }

        return ret;
    }

    /**
     * 중복되지 않은 3개의 숫자를 얻는다.
     * @return 중복되지 않은 3개의 숫자가 담긴 Numbers
     */
    public static Numbers get() {
        int[] digit = shuffledDigits();
        return new Numbers(digit[0], digit[1], digit[2]);
    }
}

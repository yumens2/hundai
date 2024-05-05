package com.ktc2.precourse.baseball.object;

/**
 * 숫자야구에서 선택된 3개의 수를 표현하는 클래스
 */
public class Numbers {
    public static final int LENGTH = 3;
    private final int[] number = new int[LENGTH];

    @Override
    public String toString() {
        return String.valueOf(number[0]) + number[1] + number[2];
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Numbers)) {
            return false;
        }

        for (int i = 0; i < LENGTH; i++) {
            if (((Numbers) obj).number[i] != this.number[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return 100 * number[0] + 10 * number[1] + number[2];
    }

    /**
     * 3개의 숫자로 Numbers를 생성
     * @param a 첫 번째 숫자
     * @param b 두 번째 숫자
     * @param c 세 번째 숫자
     */
    public Numbers(int a, int b, int c) {
        number[0] = a;
        number[1] = b;
        number[2] = c;
    }

    /**
     * 숫자를 얻는다.
     * @param index 숫자를 얻을 인덱스
     * @return index 번째 숫자
     */
    public int get(int index) {
        return number[index];
    }
}

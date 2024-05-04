package com.ktc2.precourse.baseball.logic;

import com.ktc2.precourse.baseball.object.MatchResult;
import com.ktc2.precourse.baseball.object.Numbers;

/**
 * 두 Numbers를 비교한 후 MatchResult를 생성하는 클래스
 */
public class MatchResultCreator {
    private final int[] ret;

    /**
     * 국소적 비교 결과를 계산한다.
     * @param number 상위 숫자
     * @param idx 상위 숫자의 인덱스
     * @param n 비교 대상 Numbers
     * @return 국지적 비교 결과
     */
    private int[] getLocalResult (int number, int idx, Numbers n) {
        ret[0] = 0;
        ret[1] = 0;

        for (int i = 0; i < Numbers.LENGTH; i++) {
            if (number != n.get(i)) {
                continue;
            }
            if (idx == i) {
                ret[0]++;
            } else {
                ret[1]++;
            }
        }

        return ret;
    }

    public MatchResultCreator() {
        ret = new int[2];
    }

    /**
     * 두 Numbers를 비교하여 숫자야구 비교 결과를 반환한다.
     * @param n1 비교할 Numbers 1
     * @param n2 비교할 Numbers 2
     * @return 비교 결과
     */
    public MatchResult getCompareResult(Numbers n1, Numbers n2) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < Numbers.LENGTH; i++) {
            int[] local = getLocalResult(n1.get(i), i, n2);
            strike += local[0];
            ball += local[1];
        }

        return new MatchResult(strike, ball);
    }
}

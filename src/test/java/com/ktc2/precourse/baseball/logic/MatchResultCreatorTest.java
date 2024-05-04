package com.ktc2.precourse.baseball.logic;

import com.ktc2.precourse.baseball.object.MatchResult;
import com.ktc2.precourse.baseball.object.Numbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatchResultCreatorTest {
    static final MatchResultCreator creator = new MatchResultCreator();
    int[][] testData = {
            //numbers1  numbers2    MatchResult(strike, ball)
            //모든 숫자가 맞는 경우
            {1, 2, 3,   1, 2, 3,    3, 0},
            {1, 2, 3,   1, 3, 2,    1, 2},
            {1, 2, 3,   2, 1, 3,    1, 2},
            {1, 2, 3,   2, 3, 1,    0, 3},
            {1, 2, 3,   3, 1, 2,    0, 3},
            {1, 2, 3,   3, 2, 1,    1, 2},

            //두 숫자가 맞는 경우
            {1, 2, 3,   1, 2, 9,    2, 0},
            {1, 2, 3,   1, 9, 2,    1, 1},
            {1, 2, 3,   2, 1, 9,    0, 2},
            {1, 2, 3,   2, 9, 1,    0, 2},
            {1, 2, 3,   9, 1, 2,    0, 2},
            {1, 2, 3,   9, 2, 1,    1, 1},

            //한 숫자가 맞는 경우
            {1, 2, 3,   1, 8, 9,    1, 0},
            {1, 2, 3,   1, 9, 8,    1, 0},
            {1, 2, 3,   8, 1, 9,    0, 1},
            {1, 2, 3,   8, 9, 1,    0, 1},
            {1, 2, 3,   9, 1, 8,    0, 1},
            {1, 2, 3,   9, 8, 1,    0, 1},

            //모두 안 맞는 경우
            {1, 2, 3,   7, 8, 9,    0, 0}, //18-th idx
            {1, 2, 3,   7, 9, 8,    0, 0},
            {1, 2, 3,   8, 7, 9,    0, 0},
            {1, 2, 3,   8, 9, 7,    0, 0},
            {1, 2, 3,   9, 7, 8,    0, 0},
            {1, 2, 3,   9, 8, 7,    0, 0}
    };

    @Test
    void getCompareResult() {
        //일반적인 매치 결과에 대한 테스트
        for (int[] t : testData) {
            assertThat(creator.getCompareResult(
                    new Numbers(t[0], t[1], t[2]),
                    new Numbers(t[3], t[4], t[5])))
                    .isEqualTo(new MatchResult(t[6], t[7]));
        }

        //모두 일치할 때 테스트
        assertThat(creator.getCompareResult(
                new Numbers(testData[0][0], testData[0][1], testData[0][2]),
                new Numbers(testData[0][3], testData[0][4], testData[0][5]))
                .isAllStrike())
                .isTrue();

        //모두 불일치할 때 테스트
        for (int i = 0; i < 6; i++) {
            int j = i + 18;
            assertThat(creator.getCompareResult(
                            new Numbers(testData[j][0], testData[j][1], testData[j][2]),
                            new Numbers(testData[j][3], testData[j][4], testData[j][5]))
                    .isNothing())
                    .isTrue();
        }
    }
}
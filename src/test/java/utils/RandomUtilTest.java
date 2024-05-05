package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomUtilTest {

    @DisplayName("중복되지 않은 임의의 세 자리 수를 생성한다.")
    @Test
    void getRandomNumbers() {
        // 1000번 반복
        for (int i = 0; i < 1000; i++) {

            int[] randomNumbers = RandomUtil.getRandomNumbers();

            // 배열의 요소가 총 3개인지 검사
            assertThat(randomNumbers).hasSize(3);

            // 각 배열의 요소 정수 값이 0~9인지 검사
            for (int randomNumber : randomNumbers) {
                assertThat(randomNumber).isBetween(1, 9);
            }

            // 중복 검사
            assertThat(randomNumbers).doesNotHaveDuplicates();

        }
    }

}

package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GenerateRandomNumberTest {

    @Test
    @DisplayName("1~9까지의 랜덤 정수 세 자리 값 생성")
    void getRandomNumberList() {
        GenerateRandomNumber generator = new GenerateRandomNumber();
        List<Integer> randomNumbers = generator.getRandomNumberList();

        assertThat(randomNumbers).isNotNull();
        assertThat(randomNumbers).hasSize(3);
        assertThat(randomNumbers).doesNotContain(0);

        for (int number : randomNumbers) {
            assertThat(number).isBetween(1, 9);
        }
    }
}
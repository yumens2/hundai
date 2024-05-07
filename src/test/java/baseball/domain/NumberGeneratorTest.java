package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @Test
    @DisplayName("testGenerateNumber() : 컴퓨터는 1-9까지 서로 다른 임의의 수를 3개를 선택한다.")
    public void testGenerateNumber() {
        String number = NumberGenerator.generateNumber();
        assertThat(number).hasSize(3);
        assertThat(number).matches("[1-9]+");
        assertThat(number.chars().distinct().count()).isEqualTo(3);
    }

}
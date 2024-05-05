import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CreateNumTest {

    @Test
    public void testCreateNumbers() {
        String result = CreateNum.createNumbers();
        assertThat(result).hasSize(3); // 결과 문자열의 길이는 3이어야 함

        // 각 자리수가 1 이상 9 이하의 숫자인지 확인
        for (char c : result.toCharArray()) {
            int num = Character.getNumericValue(c);
            assertThat(num).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
        }

        // 중복된 숫자가 없는지 확인
        assertThat(result).doesNotContainAnyWhitespaces();
    }
}

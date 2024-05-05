import camp.nextstep.edu.application.core.DefenseResult;
import camp.nextstep.edu.application.core.DefenseResultMatcher;
import camp.nextstep.edu.application.core.DefenseResultMatcherImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DefenseResultMatcherTests {

    private DefenseResultMatcher matcher;

    @BeforeEach
    void setUp() {
        matcher = new DefenseResultMatcherImpl();
    }

    @Test
    @DisplayName("3스트라이크 테스트")
    void matchTest() {
        // given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3);

        // when
        DefenseResult result = matcher.match(computerNumbers, playerNumbers);

        // then
        assertThat(result.strikesCount()).isEqualTo(3);
        assertThat(result.ballCount()).isEqualTo(0);
        assertThat(result.isStrikeOut()).isTrue();
    }

    @Test
    @DisplayName("1스트라이크 1볼 테스트")
    void matchTest2() {
        // given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(1, 3, 2);

        // when
        DefenseResult result = matcher.match(computerNumbers, playerNumbers);

        // then
        assertThat(result.strikesCount()).isEqualTo(1);
        assertThat(result.ballCount()).isEqualTo(2);
        assertThat(result.isStrikeOut()).isFalse();
    }

    @Test
    @DisplayName("낫싱 테스트")
    void matchTest3() {
        // given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(4, 5, 6);

        // when
        DefenseResult result = matcher.match(computerNumbers, playerNumbers);

        // then
        assertThat(result.strikesCount()).isEqualTo(0);
        assertThat(result.ballCount()).isEqualTo(0);
        assertThat(result.isNothing()).isTrue();
    }
}

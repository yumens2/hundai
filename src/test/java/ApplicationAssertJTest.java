import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationAssertJTest {

    @Test
    void testPlayerInput() {
        // 올바른 값 입력
        assertThat(Application.playerInput("123")).containsExactly(1, 2, 3);

        // 잘못된 값 입력
        // 0입력
        assertThatThrownBy(() -> Application.playerInput("012"))
            .isInstanceOf(IllegalArgumentException.class);
        // 중복된 수 입력
        assertThatThrownBy(() -> Application.playerInput("112"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testConvertIntArray() {
        assertThat(Application.convertIntArray("123")).containsExactly(1, 2, 3);
    }

    @Test
    void testMakeNum() {
        int[] num = Application.makeNum();
        assertThat(num).hasSize(3);
        assertThat(num[0]).isGreaterThan(0).isLessThan(10);
        assertThat(num[1]).isGreaterThan(0).isLessThan(10).isNotEqualTo(num[0]);
        assertThat(num[2]).isGreaterThan(0).isLessThan(10).isNotEqualTo(num[0]).isNotEqualTo(num[1]);
    }

    @Test
    void testCompareNum() {
        // 3스트라이크
        assertThat(Application.compareNum(new int[]{1, 2, 3}, new int[]{1, 2, 3})).isFalse();

        // 1볼 1스트라이크
        assertThat(Application.compareNum(new int[]{1, 2, 3}, new int[]{3, 2, 1})).isTrue();

        // 낫싱
        assertThat(Application.compareNum(new int[]{1, 2, 3}, new int[]{4, 5, 6})).isTrue();
    }

    @Test
    void testRestart() {
        // 1선택 (게임 재실행 True)
        assertThat(Application.restart("1")).isTrue();
        // 2선택 (애플리케이션 종료 False)
        assertThat(Application.restart("2")).isFalse();
        // 잘못된 입력
        assertThatThrownBy(() -> Application.restart("3"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}

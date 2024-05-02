import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("RestartTest")
public class ReStartTest {

    public static InputStream InitInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("입력 타입 오류")
    void IllegalInput1() {
        InputStream in = InitInputStream("a");
        System.setIn(in);
        ReStart rs = new ReStart();
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(rs::selectContinue)
            .withMessage("1 또는 2를 입력해야 합니다.");
    }

    @Test
    @DisplayName("입력 범위 오류")
    void IllegalInput2() {
        InputStream in = InitInputStream("35");
        System.setIn(in);
        ReStart rs = new ReStart();
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(rs::selectContinue)
            .withMessage("1 또는 2를 입력해야 합니다.");
    }

    @Test
    @DisplayName("정상입력1")
    void RightInput1() {
        InputStream in = InitInputStream("1");
        System.setIn(in);
        ReStart rs = new ReStart();
        assertThat(rs.selectContinue()).
            isTrue();
    }

    @Test
    @DisplayName("정상입력2")
    void RightInput2() {
        InputStream in = InitInputStream("2");
        System.setIn(in);
        ReStart rs = new ReStart();
        assertThat(rs.selectContinue()).
            isFalse();
    }
}

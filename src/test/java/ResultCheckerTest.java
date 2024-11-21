import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("ResultCheckerTest")
public class ResultCheckerTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setUpOutputStream() {
        System.setOut(new PrintStream(out));
    }

    @Test
    @DisplayName("낫싱")
    void Noting() {
        ResultChecker rc = new ResultChecker();

        assertThat(rc.checkRes(new ArrayList<>(Arrays.asList(1, 2, 3)),
            new ArrayList<>(Arrays.asList(4, 5, 6))))
            .isTrue();
        assertThat(out.toString().trim())
            .isEqualTo("낫싱");
    }

    @Test
    @DisplayName("볼")
    void OnlyBall() {
        ResultChecker rc = new ResultChecker();

        rc.checkRes(new ArrayList<>(Arrays.asList(1, 2, 3)),
            new ArrayList<>(Arrays.asList(2, 4, 5)));
        assertThat(out.toString().trim()).isEqualTo("1볼");
        out.reset();
        rc.checkRes(new ArrayList<>(Arrays.asList(1, 2, 3)),
            new ArrayList<>(Arrays.asList(2, 1, 4)));
        assertThat(out.toString().trim()).isEqualTo("2볼");
        out.reset();
        rc.checkRes(new ArrayList<>(Arrays.asList(1, 2, 3)),
            new ArrayList<>(Arrays.asList(3, 1, 2)));
        assertThat(out.toString().trim()).isEqualTo("3볼");
    }

    @Test
    @DisplayName("스트라이크")
    void OnlyStrike() {
        ResultChecker rc = new ResultChecker();

        rc.checkRes(new ArrayList<>(Arrays.asList(1, 2, 3)),
            new ArrayList<>(Arrays.asList(1, 4, 5)));
        assertThat(out.toString().trim()).isEqualTo("1스트라이크");
        out.reset();
        rc.checkRes(new ArrayList<>(Arrays.asList(1, 2, 3)),
            new ArrayList<>(Arrays.asList(1, 4, 3)));
        assertThat(out.toString().trim()).isEqualTo("2스트라이크");
        out.reset();

        assertThat(rc.checkRes(new ArrayList<>(Arrays.asList(1, 2, 3)),
            new ArrayList<>(Arrays.asList(1, 2, 3))))
            .isFalse();
        assertThat(out.toString().trim()).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("볼 + 스트라이크")
    void BallAndStrike() {
        ResultChecker rc = new ResultChecker();

        rc.checkRes(new ArrayList<>(Arrays.asList(1, 2, 3)),
            new ArrayList<>(Arrays.asList(1, 3, 4)));
        assertThat(out.toString().trim()).isEqualTo("1볼 1스트라이크");
        out.reset();
        rc.checkRes(new ArrayList<>(Arrays.asList(1, 2, 3)),
            new ArrayList<>(Arrays.asList(1, 3, 2)));
        assertThat(out.toString().trim()).isEqualTo("2볼 1스트라이크");
    }

}

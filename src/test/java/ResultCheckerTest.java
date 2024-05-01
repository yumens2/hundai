import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.*;

public class ResultCheckerTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setUpOutputStream() {
        System.setOut(new PrintStream(out));
    }

    @Test
    void Noting(){
       ResultChecker rc = new ResultChecker();

       assertThat(rc.checkRes(new ArrayList<>(Arrays.asList(1,2,3)),new ArrayList<>(Arrays.asList(4,5,6))))
               .isFalse();
       assertThat(out.toString().trim())
               .isEqualTo("낫싱");
    }

    @Test
    void OnlyBall(){
        ResultChecker rc = new ResultChecker();

        rc.checkRes(new ArrayList<>(Arrays.asList(1,2,3)),new ArrayList<>(Arrays.asList(2,4,5)));
        assertThat(out.toString().trim()).isEqualTo("1볼");
        out.reset();
        rc.checkRes(new ArrayList<>(Arrays.asList(1,2,3)),new ArrayList<>(Arrays.asList(2,1,4)));
        assertThat(out.toString().trim()).isEqualTo("2볼");
        out.reset();
        rc.checkRes(new ArrayList<>(Arrays.asList(1,2,3)),new ArrayList<>(Arrays.asList(3,1,2)));
        assertThat(out.toString().trim()).isEqualTo("3볼");
    }

    @Test
    void OnlyStrike(){
        ResultChecker rc = new ResultChecker();

        rc.checkRes(new ArrayList<>(Arrays.asList(1,2,3)),new ArrayList<>(Arrays.asList(1,4,5)));
        assertThat(out.toString().trim()).isEqualTo("1스트라이크");
        out.reset();
        rc.checkRes(new ArrayList<>(Arrays.asList(1,2,3)),new ArrayList<>(Arrays.asList(1,4,3)));
        assertThat(out.toString().trim()).isEqualTo("2스트라이크");
        out.reset();

        assertThat(rc.checkRes(new ArrayList<>(Arrays.asList(1,2,3)),new ArrayList<>(Arrays.asList(1,2,3))))
                .isTrue();
        assertThat(out.toString().trim()).isEqualTo("3스트라이크");
    }

    @Test
    void BallAndStrike(){
        ResultChecker rc = new ResultChecker();

        rc.checkRes(new ArrayList<>(Arrays.asList(1,2,3)),new ArrayList<>(Arrays.asList(1,3,4)));
        assertThat(out.toString().trim()).isEqualTo("1볼 1스트라이크");
        out.reset();
        rc.checkRes(new ArrayList<>(Arrays.asList(1,2,3)),new ArrayList<>(Arrays.asList(1,3,2)));
        assertThat(out.toString().trim()).isEqualTo("2볼 1스트라이크");
    }


}

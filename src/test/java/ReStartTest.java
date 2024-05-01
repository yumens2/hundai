import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.assertj.core.api.Assertions.*;

public class ReStartTest {

    public static InputStream InitInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    void IllegalInput1(){
        InputStream in = InitInputStream("a");
        System.setIn(in);
        ReStart rs = new ReStart();
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(rs::selectContinue)
                .withMessage("You must enter 1 or 2.");
    }

    @Test
    void IllegalInput2(){
        InputStream in = InitInputStream("35");
        System.setIn(in);
        ReStart rs = new ReStart();
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(rs::selectContinue)
                .withMessage("You must enter 1 or 2.");
    }

    @Test
    void RightInput1(){
        InputStream in = InitInputStream("1");
        System.setIn(in);
        ReStart rs = new ReStart();
        assertThat(rs.selectContinue()).
                isTrue();
    }
    @Test
    void RightInput2(){
        InputStream in = InitInputStream("2");
        System.setIn(in);
        ReStart rs = new ReStart();
        assertThat(rs.selectContinue()).
                isFalse();
    }
}

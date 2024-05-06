import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ViewTest {

    OutputStream out;

    @BeforeEach
    void beforeEach() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    void guessView() {
        InputStream in = new ByteArrayInputStream("123\n".getBytes());
        View.resetScanner(in);

        int num1 = View.guessView();

        Assertions.assertThat(num1).isEqualTo(123);
    }

    @Test
    void hintViewNothing() {
        ResultDto resultDto = new ResultDto(0, 0);

        View.hintView(resultDto);

        Assertions.assertThat(out.toString().trim()).isEqualTo("낫싱");
    }

    @Test
    void hintViewStrike() {
        ResultDto resultDto = new ResultDto(2, 0);

        View.hintView(resultDto);

        Assertions.assertThat(out.toString().trim()).isEqualTo("2스트라이크");
    }

    @Test
    void hintViewBall() {
        ResultDto resultDto = new ResultDto(0, 3);

        View.hintView(resultDto);

        Assertions.assertThat(out.toString().trim()).isEqualTo("3볼");
    }

    @Test
    void hintViewBoth() {
        ResultDto resultDto = new ResultDto(1, 1);

        View.hintView(resultDto);

        Assertions.assertThat(out.toString().trim()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void successView() {
        InputStream in = new ByteArrayInputStream("1\n".getBytes());
        View.resetScanner(in);

        int num1 = View.guessView();

        Assertions.assertThat(num1).isEqualTo(1);
    }
}
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.*;



public class InputTest {

    public static InputStream InitInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    public void tooLongInput() {
        InputStream in = InitInputStream("1234");
        System.setIn(in);
        Input input =new Input();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(input::getUserNumber)
                .withMessage("You must enter a 3-digit number.");
    }

    @Test
    public void NotIntegerInput() {
        InputStream in = InitInputStream("ab3");
        System.setIn(in);
        Input input =new Input();


        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(input::getUserNumber)
                .withMessage("Input other than integers is not allowed.");
    }

    @Test
    public void DuplicationInput() {
        InputStream in = InitInputStream("113");
        System.setIn(in);
        Input input =new Input();


        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(input::getUserNumber)
                .withMessage("The inputs must be different integers.");
    }

    @Test
    public void RightInput() {
        InputStream in = InitInputStream("548");
        System.setIn(in);
        Input input =new Input();
        ArrayList<Integer> res = input.getUserNumber();

        assertThat(res.size()).isEqualTo(3);
    }
}

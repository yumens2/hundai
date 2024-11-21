import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Input test")
public class InputTest {

    public static InputStream InitInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("입력길이초과")
    public void tooLongInput() {
        InputStream in = InitInputStream("1234");
        System.setIn(in);
        Input input = new Input();

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(input::getUserNumber)
            .withMessage("3자리 숫자를 입력해야 합니다.");
    }

    @Test
    @DisplayName("입력타입오류")
    public void NotIntegerInput() {
        InputStream in = InitInputStream("ab3");
        System.setIn(in);
        Input input = new Input();

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(input::getUserNumber)
            .withMessage("정수 이외의 입력은 허용되지 않습니다.");
    }

    @Test
    @DisplayName("중복오류")
    public void DuplicationInput() {
        InputStream in = InitInputStream("113");
        System.setIn(in);
        Input input = new Input();

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(input::getUserNumber)
            .withMessage("입력은 서로 다른 정수여야 합니다.");
    }

    @Test
    @DisplayName("정상입력")
    public void RightInput() {
        InputStream in = InitInputStream("548");
        System.setIn(in);
        Input input = new Input();
        ArrayList<Integer> res = input.getUserNumber();

        assertThat(res.size()).isEqualTo(3);
    }
}

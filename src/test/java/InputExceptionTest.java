import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.io.ByteArrayInputStream;

public class InputExceptionTest {

    @Test
    public void testInputUserNum() {
        // 유효한 입력을 시뮬레이트하기 위해 System.in을 임의의 데이터로 변경
        System.setIn(new ByteArrayInputStream("123\n".getBytes()));

        // 정상적인 입력 테스트
        String userInput = InputException.inputUserNum();
        assertThat(userInput).isEqualTo("123");

        // 3자리 이상 입력했을 때 예외 확인
        System.setIn(new ByteArrayInputStream("1234\n".getBytes()));
        assertThatThrownBy(InputException::inputUserNum)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("중복없이 3자리 숫자를 입력해주세요.");

        // 중복된 숫자 입력했을 때 예외 확인
        System.setIn(new ByteArrayInputStream("112\n".getBytes()));
        assertThatThrownBy(InputException::inputUserNum)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("중복없이 3자리 숫자를 입력해주세요.");

        // 숫자가 아닌 문자를 입력했을 때 예외 확인
        System.setIn(new ByteArrayInputStream("abc\n".getBytes()));
        assertThatThrownBy(InputException::inputUserNum)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("중복없이 3자리 숫자를 입력해주세요.");
    }

    @Test
    public void testInputChoice() {
        // 유효한 입력을 시뮬레이트하기 위해 System.in을 임의의 데이터로 변경
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));

        // 정상적인 입력 테스트
        int choice = InputException.inputChoice();
        assertThat(choice).isEqualTo(1);

        // 1 혹은 2 이외의 값 입력했을 때 예외 확인
        System.setIn(new ByteArrayInputStream("3\n".getBytes()));
        assertThatThrownBy(InputException::inputChoice)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("1 혹은 2를 입력해주세요.");
    }
}

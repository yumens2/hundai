import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;
    private SoftAssertions softAssertions;

    private final InputStream originalSystemIn = System.in;

    @BeforeEach
    void setUp() throws IOException {
        inputView = new InputView();
        softAssertions = new SoftAssertions();
    }

    @AfterEach
    void recoverInput() {
        System.setIn(originalSystemIn);
    }

    public void makeInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        inputView.br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Nested
    @DisplayName("read Number에 관해")
    class ReadNumberCheck {

        @Test
        @DisplayName("입력한 값이 정수리스트로 제대로 반환되는지 확인")
        void isInputChangeToIntegerList() throws IOException {
            //given
            makeInput("123");

            List<Integer> list = inputView.readNumber();

            softAssertions.assertThat(list).isEqualTo(Arrays.asList(1, 2, 3));
        }

        @Test
        @DisplayName("3이외의 길이 입력시 throw 발생")
        void lengthIsNotThree_Throw_IllegalException() {
            makeInput("12");

            assertThrows(IllegalArgumentException.class, InputView::readNumber);
        }

        @Test
        @DisplayName("숫자를 제외한 값 입력시 throw 발생")
        void inputIsNotNumber_Throw_IllegalException() {
            makeInput("abc");

            assertThrows(IllegalArgumentException.class, InputView::readNumber);
        }

        @Test
        @DisplayName("1~9범위 밖 숫자 입력시 throw 발생")
        void numberIsNotBetweenOneAndNine_Throw_IllegalException() {
            makeInput("012");

            assertThrows(IllegalArgumentException.class, InputView::readNumber);
        }
    }

    @Nested
    @DisplayName("read State에 관해")
    class ReadStateCheck {

        @Test
        @DisplayName("입력한 값이 정수로 제대로 반환되는지 확인")
        void isInputChangeToIntegerList() throws IOException {
            //given
            makeInput("1");

            int number = inputView.readState();

            softAssertions.assertThat(number).isEqualTo(1);
        }

        @Test
        @DisplayName("1이외의 길이 입력시 throw 발생")
        void lengthIsNotThree_Throw_IllegalException() {
            makeInput("12");

            assertThrows(IllegalArgumentException.class, InputView::readState);
        }

        @Test
        @DisplayName("숫자를 제외한 값 입력시 throw 발생")
        void inputIsNotNumber_Throw_IllegalException() {
            makeInput("a");

            assertThrows(IllegalArgumentException.class, InputView::readState);
        }

        @Test
        @DisplayName("1~9범위 밖 숫자 입력시 throw 발생")
        void numberIsNotBetweenOneAndNine_Throw_IllegalException() {
            makeInput("3");

            assertThrows(IllegalArgumentException.class, InputView::readState);
        }
    }
}



package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameServiceTest {

    private GameService gameService = new GameService();

    @DisplayName("사용자로부터 세 자리의 수를 입력 받는다.")
    @Test
    void inputThreeDigits() {
        //given
        String input = "129";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        int[] numbers = gameService.inputThreeDigits();

        //then
        assertThat(numbers).hasSize(3);
        for (int i = 0; i < numbers.length; i++) {
            assertThat(numbers[i]).isBetween(1, 9);
        }
    }

    @DisplayName("[예외 처리] 사용자로부터 세 자리의 수를 입력 받는데, 숫자가 아니면 예외를 발생시킨다.")
    @Test
    void inputThreeDigitsWithoutNumeric() {
        //given
        String input = "12a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when & then
        assertThatThrownBy(() -> gameService.inputThreeDigits())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[예외 처리] 사용자로부터 세 자리의 수를 입력 받는데, 세 자리 수가 아니면 예외를 발생시킨다.")
    @Test
    void inputThreeDigitsWithNonThreeDigits() {
        //given
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when & then
        assertThatThrownBy(() -> gameService.inputThreeDigits())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정수를 배열로 변환한다. (각 자리 수를 요소로 담은 배열 생성)")
    @Test
    void intToArrayInt() {
        //given
        int num = 123;

        //when
        int[] numbers = gameService.intToArrayInt(num);

        //then
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("[게임을 종료하는 경우] 게임을 종료할 건지 체크한다.")
    @Test
    void askForEndWithEnd() throws Exception {
        //given
        String input = "Y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        boolean isEnd = gameService.askForEnd();

        //then
        assertThat(isEnd).isTrue();
    }

    @DisplayName("[재시작하는 경우] 게임을 종료할 건지 체크한다.")
    @Test
    void askForEndWithRestart() throws Exception {
        //given
        String input = "N";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        boolean isEnd = gameService.askForEnd();

        //then
        assertThat(isEnd).isFalse();
    }

}

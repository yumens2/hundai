package baseball.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InputViewTest {

    private final InputStream systemIn = System.in;

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
        InputView.br = new BufferedReader(new InputStreamReader(System.in));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(systemIn);
    }

    @Test
    void 유효한_숫자_입력_테스트() throws IOException {
        // given
        provideInput("123\n");

        // when
        List<Integer> result = InputView.readNumbers();

        // then
        assertEquals(java.util.Arrays.asList(1, 2, 3), result);
    }

    @Test
    void 잘못된_길이_입력_테스트() {
        // given
        provideInput("12\n");

        // when & then
        assertThrows(IllegalArgumentException.class, InputView::readNumbers);
    }

    @Test
    void 범위_밖_숫자_입력_테스트() {
        // given
        provideInput("180\n");

        // when & then
        assertThrows(IllegalArgumentException.class, InputView::readNumbers);
    }

    @Test
    void 문자_입력_테스트() {
        // given
        provideInput("abc\n");

        // when & then
        assertThrows(IllegalArgumentException.class, InputView::readNumbers);
    }

    @Test
    void 게임_재시작_YES_입력_테스트() throws IOException {
        // given
        provideInput("1\n");

        // when
        boolean restart = InputView.readWantGameRestart();

        // then
        assertTrue(restart);
    }

    @Test
    void 게임_재시작_NO_입력_테스트() throws IOException {
        // given
        provideInput("2\n");

        // when
        boolean restart = InputView.readWantGameRestart();

        // then
        assertFalse(restart);
    }

    @Test
    void 게임_재시작_유효하지_않은_플래그_테스트() {
        // given
        provideInput("3\n");

        // when & then
        assertThrows(IllegalArgumentException.class, InputView::readWantGameRestart);
    }

    @Test
    void 게임_재시작_입력_길이_오류_테스트() {
        // given
        provideInput("\n");

        // when & then
        assertThrows(IllegalArgumentException.class, InputView::readWantGameRestart);
    }
}

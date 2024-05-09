package utility;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

class InputStringReceiverTest {

    @BeforeEach
    void setUp() {
        InputStringReceiver.close();
    }

    @Test
    @DisplayName("Scanner 인스턴스 확인 테스트")
    void getInstance() {
        Scanner scanner = InputStringReceiver.getInstance();
        Assertions.assertThat(scanner).isSameAs(InputStringReceiver.getInstance());
    }

    @Test
    @DisplayName("Scanner close 확인 테스트")
    void close() {
        Scanner scanner = InputStringReceiver.getInstance();
        InputStringReceiver.close();
        Assertions.assertThat(scanner).isNotSameAs(InputStringReceiver.getInstance());
    }

    @Test
    @DisplayName("Scanner 입력 문자열 확인 테스트")
    void getInputString() {
        String inputString = "123";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));

        Assertions.assertThat(inputString).isEqualTo(InputStringReceiver.getInputString());
    }
}
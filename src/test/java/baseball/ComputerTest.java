package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Random;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    @DisplayName("랜덤값 테스트")
    void test_makeRandomNum() {
        // given
        Random random = new Random() {
            @Override
            public int nextInt(int bits) {
                return 0;
            }
        };

        // when
        Computer computer = new Computer(random);

        // then
        assertThat(computer.getProblemNum()).isEqualTo("123");
    }

}
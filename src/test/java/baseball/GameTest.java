package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Random;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    @DisplayName("게임 진행 테스트")
    void test_play() {
        // given
        String input1 = "123";
        String input2 = "2";
        ByteArrayInputStream inputStream1 = new ByteArrayInputStream(input1.getBytes());
        ByteArrayInputStream inputStream2 = new ByteArrayInputStream(input2.getBytes());
        Scanner scanner1 = new Scanner(inputStream1);
        Scanner scanner2 = new Scanner(inputStream2);

        Random random = new Random() {
            @Override
            public int nextInt(int bits) {
                return 0;
            }
        };

        // when
        Computer computer = new Computer(random);
        User user = new User(scanner1);
        Game game = new Game(user, computer, scanner2);

        // then
        assertDoesNotThrow(game::play);
    }
}
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("사용자 입력 갯수 테스트")
    @Test
    void inputSizeTest() {
        Player player=new Player();

        String inputString = "123";
        InputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);
        ArrayList<Integer> user = player.input();

        Assertions.assertThat(user.size()).isEqualTo(3);
    }
    @DisplayName("사용자 입력 범위 테스트")
    @Test
    void inputRangeTest() {
        Player player=new Player();
        String inputString = "123";
        InputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);

        ArrayList<Integer> user = player.input();
        Assertions.assertThat(user.stream().allMatch(n -> n>=1 && n <= 9)).isTrue();
    }

    @DisplayName("잘못된 사용자 입력 테스트")
    @Test
    void invalidInputTest() {
        Player player=new Player();

        assertThrowsExactly(IllegalArgumentException.class, () -> player.inputCheck("1234"));
        assertThrowsExactly(IllegalArgumentException.class, () -> player.inputCheck("112"));
        assertThrowsExactly(IllegalArgumentException.class, () -> player.inputCheck("1a3"));
    }
}
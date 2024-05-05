import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompareTest {
    @DisplayName("포함된 숫자 개수 확인")
    @Test
    void contain() {
        // given
        Compare compare = new Compare();
        List<String> player = new ArrayList<>();
        player.add("1");
        player.add("2");
        player.add("3");
        StringBuilder computer = new StringBuilder("234");

        // when
        int contain = compare.contain(player, computer);

        // then
        assertEquals(2, contain);
    }

    @DisplayName("스트라이크 개수 확인")
    @Test
    void strike() {
        // given
        Compare compare = new Compare();
        List<String> player = new ArrayList<>();
        player.add("4");
        player.add("2");
        player.add("5");
        StringBuilder computer = new StringBuilder("425");

        // when
        int strike = compare.strike(player, computer);

        // then
        assertEquals(3, strike);
    }
}
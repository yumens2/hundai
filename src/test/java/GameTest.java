import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

    @Test
    @DisplayName("생성한 숫자의 자릿수 확인")
    public void NumberLengthTest() {
        Computer computer = new Computer();
        List<Integer> numberList = computer.makeRandomNumber();
        assertThat(numberList.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("생성한 숫자가 전부 다른 숫자인지 확인")
    public void NumberUniqueTest() {
        Computer computer = new Computer();
        List<Integer> numberList = computer.makeRandomNumber();
        assertThat(numberList.get(0)).isNotEqualTo(numberList.get(1));
        assertThat(numberList.get(1)).isNotEqualTo(numberList.get(2));
        assertThat(numberList.get(0)).isNotEqualTo(numberList.get(2));

    }
}

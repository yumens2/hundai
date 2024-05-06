package game.BaseballGame.model;

import game.gamePack.BaseballGame.model.Computer;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    Computer computer = Computer.getInstance();

    @Test
    @DisplayName("랜덤 숫자 사이즈 테스트")
    void getRandomNumberTest() {
        // given
        // then
        List<Integer> randomNumber = computer.getTargetNumbers();
        // when
        Assertions.assertEquals(3, randomNumber.size());
    }

    @Test
    @DisplayName("랜덤 숫자 중복 확인 테스트")
    void checkDuplicateNumberTest() {
        // given
        // then
        List<Integer> randomNumber = computer.getTargetNumbers();
        // when
        Assertions.assertNotEquals(randomNumber.get(0), randomNumber.get(1));
        Assertions.assertNotEquals(randomNumber.get(1), randomNumber.get(2));
        Assertions.assertNotEquals(randomNumber.get(0), randomNumber.get(2));
    }

    @Test
    @DisplayName("랜덤 숫자 범위 확인 테스트")
    void checkRangeNumberTest() {
        // given
        // then
        List<Integer> randomNumber = computer.getTargetNumbers();
        // when
        for (int i = 0; i < 3; i++) {
            Assertions.assertTrue(randomNumber.get(i) >= 1 && randomNumber.get(i) <= 9);
        }
    }


}

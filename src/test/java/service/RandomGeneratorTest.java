package service;

import static org.junit.jupiter.api.Assertions.*;

import model.Number;
import org.junit.jupiter.api.Test;

class RandomGeneratorTest {

    private final RandomGenerator randomGenerator;

    public RandomGeneratorTest() {
        randomGenerator = new RandomGenerator();
    }

    /**
     * 세자리 숫자가 모두 다름을 검사하기 위해 checkingCondition 메소드를 이용한다.
     * 만약 세자리 숫자 중에 겹치는 것이 있으면 예외를 터뜨리므로 테스트가 실패할 것이다.
     */

    @Test
    void creatingDifferentDigits() {
        for (int i=0;i<1000;i++) {
            Number number = randomGenerator.createNumber();
            assertDoesNotThrow( () -> GameService.checkingCondition(number.toInt()));
        }
    }

}
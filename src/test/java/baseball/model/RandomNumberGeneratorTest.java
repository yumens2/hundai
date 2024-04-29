package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    private RandomNumberGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new RandomNumberGenerator();
    }

    @Test
    public void 리스트는_세_개의_숫자를_포함해야_한다() {
        // when
        List<Integer> randomNumbers = generator.generateRandomNumbers();

        // then
        assertEquals(3, randomNumbers.size(), "리스트의 크기는 정확히 3이어야 한다.");
    }

    @Test
    public void 리스트에는_중복된_숫자가_없어야_한다() {
        // when
        List<Integer> randomNumbers = generator.generateRandomNumbers();

        // then
        assertEquals(randomNumbers.stream().distinct().count(), randomNumbers.size(), "리스트에는 중복된 숫자가 없어야 한다.");
    }

    @Test
    public void 생성된_숫자는_1에서_9_사이여야_한다() {
        // when
        List<Integer> randomNumbers = generator.generateRandomNumbers();

        // then
        assertTrue(randomNumbers.stream().allMatch(num -> num >= 1 && num <= 9));
    }
}

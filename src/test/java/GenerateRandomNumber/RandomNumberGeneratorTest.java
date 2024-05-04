package GenerateRandomNumber;

import static GenerateRandomNumber.RandomNumberGeneratorConfigure.LENGTH;
import static GenerateRandomNumber.RandomNumberGeneratorConfigure.MAX_VALUE;
import static GenerateRandomNumber.RandomNumberGeneratorConfigure.MIN_VALUE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RandomNumberGeneratorTest {
    // MIN_VALUE와 MAX_VALUE 사이에 있는지 확인
    private boolean numberInRange(Integer number) {
        return number >= MIN_VALUE.getValue() && number <= MAX_VALUE.getValue();
    }

    // 조건에 맞는 임의의 무작위 난수 생성
    static Stream<Arguments> generateData() {
        return Stream.of(
            Arguments.of(RandomNumberGenerator.generateRandomNumber()),
            Arguments.of(RandomNumberGenerator.generateRandomNumber()),
            Arguments.of(RandomNumberGenerator.generateRandomNumber()),
            Arguments.of(RandomNumberGenerator.generateRandomNumber()),
            Arguments.of(RandomNumberGenerator.generateRandomNumber()),
            Arguments.of(RandomNumberGenerator.generateRandomNumber()),
            Arguments.of(RandomNumberGenerator.generateRandomNumber()),
            Arguments.of(RandomNumberGenerator.generateRandomNumber()),
            Arguments.of(RandomNumberGenerator.generateRandomNumber()),
            Arguments.of(RandomNumberGenerator.generateRandomNumber()),
            Arguments.of(RandomNumberGenerator.generateRandomNumber()),
            Arguments.of(RandomNumberGenerator.generateRandomNumber()),
            Arguments.of(RandomNumberGenerator.generateRandomNumber()),
            Arguments.of(RandomNumberGenerator.generateRandomNumber()),
            Arguments.of(RandomNumberGenerator.generateRandomNumber()),
            Arguments.of(RandomNumberGenerator.generateRandomNumber()),
            Arguments.of(RandomNumberGenerator.generateRandomNumber()),
            Arguments.of(RandomNumberGenerator.generateRandomNumber()),
            Arguments.of(RandomNumberGenerator.generateRandomNumber()),
            Arguments.of(RandomNumberGenerator.generateRandomNumber())
        );
    }

    @DisplayName("Generate Random Number")
    @ParameterizedTest
    @MethodSource("generateData")
    void generateRandomNumber(List<Integer> generatedNumbers) {
        assertAll("generatedNumbers",
            // 수열의 길이 제한
            () -> assertEquals(generatedNumbers.size(), LENGTH.getValue()),
            () -> assertFalse(generatedNumbers.isEmpty()),
            () -> assertTrue(generatedNumbers.size() <= 10),

            // 모든 수가 달라야 한다.
            () -> assertEquals(generatedNumbers.stream().distinct().count(), LENGTH.getValue()),

            // 첫번째 수는 반드시 0이 아니어야 한다.
            () -> assertNotEquals(generatedNumbers.get(0), 0),

            // 모든 수는 MIN_VALUE와 MAX_VALUE 사이에 있어야 한다.
            () -> assertTrue(generatedNumbers.stream().allMatch(this::numberInRange))
        );
    }
}
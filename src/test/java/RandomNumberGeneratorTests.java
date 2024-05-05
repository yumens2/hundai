import camp.nextstep.edu.application.core.RandomNumberGenerator;
import camp.nextstep.edu.application.core.RandomNumberGeneratorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTests {

    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void setUp() {
        randomNumberGenerator = new RandomNumberGeneratorImpl();
    }

    @RepeatedTest(value = 10, name = "{displayName} - {currentRepetition}/{totalRepetitions}")
    @DisplayName("랜덤 숫자 생성 테스트")
    void createRandomNumberTest() {
        int origin = 1;
        int bound = 9;

        int randomNumber = randomNumberGenerator.nextInt(origin, bound);

        assertThat(randomNumber).isGreaterThanOrEqualTo(origin).isLessThan(bound);
    }

    @RepeatedTest(value = 10, name = "{displayName} - {currentRepetition}/{totalRepetitions}")
    @DisplayName("랜덤 숫자 생성 테스트2")
    void createRandomNumberTest2() {
        int bound = 9;

        int randomNumber = randomNumberGenerator.nextInt(bound);

        assertThat(randomNumber).isLessThan(bound);
    }
}

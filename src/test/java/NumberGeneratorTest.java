import main.NumberGenerator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class NumberGeneratorTest {
    @Test
    public void testGenerateNumber() {
        NumberGenerator generator = new NumberGenerator();
        String number = generator.generateNumber();
        assertThat(number).hasSize(3);
        assertThat(number.chars().allMatch(Character::isDigit)).isTrue();
        assertThat(number.chars().distinct().count()).isEqualTo(3);
        assertThat(number.chars().mapToObj(c -> (char) c).allMatch(c -> c >= '1' && c <= '9')).isTrue();
    }

    @Test
    public void testIsValidNumber() {
        NumberGenerator generator = new NumberGenerator();
        assertThat(generator.isValidNumber("123")).isTrue();
        assertThat(generator.isValidNumber("111")).isFalse(); // not distinct
        assertThat(generator.isValidNumber("012")).isFalse(); // contains zero
        assertThat(generator.isValidNumber("1234")).isFalse(); // too long
        assertThat(generator.isValidNumber("abc")).isFalse(); // not digits
    }
}

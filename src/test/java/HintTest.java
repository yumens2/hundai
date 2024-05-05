import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class HintTest {
    @Test
    public void testHint() {
        // given
        int rand = Computer.makeRandom();
        int user = UserInput.userInput();

        // when
        String result = Hint.hint(rand, user);

        // then
        assertThat(result).isEqualTo(Hint.hint(rand, user));
    }
}

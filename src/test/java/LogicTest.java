import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LogicTest {

    @Test
    void shouldSetComputerNumberCorrectly() {
        Logic logic = new Logic(123);
        assertThat(logic.getComputerNumber()).isEqualTo(123);
    }
}

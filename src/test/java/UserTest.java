import static org.assertj.core.api.Assertions.*;

import java.util.Scanner;
import org.junit.jupiter.api.Test;

class UserTest {

    User user = new User(new Scanner(System.in));
    @Test
    void toArray() {
        assertThat(user.toArray("123")[1]).isEqualTo(1);
    }
}
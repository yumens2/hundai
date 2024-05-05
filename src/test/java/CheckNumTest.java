import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CheckNumTest {

    CheckNum checkNum = new CheckNum();
    @Test
    void strikeCheck() {
        assertThat(checkNum.strikeCheck(new int[]{1,2,3}, new int[]{1,4,5})).isEqualTo(1);
        assertThat(checkNum.strikeCheck(new int[]{1,2,3}, new int[]{1,4,3})).isEqualTo(2);
        assertThat(checkNum.strikeCheck(new int[]{1,2,3}, new int[]{3,4,5})).isEqualTo(0);
    }

    @Test
    void ballCheck() {
        assertThat(checkNum.ballCheck(new int[]{1,2,3}, new int[]{1,3,5})).isEqualTo(1);
        assertThat(checkNum.ballCheck(new int[]{1,2,3}, new int[]{3,1,2})).isEqualTo(3);
        assertThat(checkNum.ballCheck(new int[]{1,2,3}, new int[]{1,2,3})).isEqualTo(0);
    }
}
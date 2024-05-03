import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CountNumTest {

    @Test
    public void testCountSB() {
        String user = "123";
        String comp = "123";
        String result = CountNum.CountSB(user, comp);
        assertThat(result).isEqualTo("30");
    }

    @Test
    public void testCountS() {
        String user = "123";
        String comp = "123";
        int result = CountNum.CountS(user, comp);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void testCountB() {
        String user = "123";
        String comp = "321";
        int result = CountNum.CountB(user, comp);
        assertThat(result).isEqualTo(2);
    }
}

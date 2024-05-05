import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ComputerTest {
    @Test
    public void computerTest(){
        // given
        int rand = Computer.makeRandom();

        // when

        // then
        assertThat(Computer.makeRandom()).isEqualTo(rand);
    }
}

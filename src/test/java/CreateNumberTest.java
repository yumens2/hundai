import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class CreateNumberTest {
    @Test
    void radomTest(){
        CreateNumberTest crn = new CreateNumberTest();
        int[] test = CreateNumber.create();
        assertThat(3).isEqualTo(test.length);
    }



}

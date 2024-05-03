import model.BaseballNumberGenerator;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestController {
    @DisplayName("Generator Test")
    @Test
    void BaseballNumberSizeTest(){
        //given
        final BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();
        //when
        final List<Integer> baseballNumber = baseballNumberGenerator.generate();
        //then
        assertThat(baseballNumber.stream().allMatch(v ->v>=1 && v <=9)).isTrue();
    }
}

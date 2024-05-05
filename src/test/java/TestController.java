import model.BaseballNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class TestController {

    @DisplayName("Generator Test")
    @Test
    void BaseballNumberRangeTest(){
        //given
        final BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();
        //when
        final ArrayList<Integer> baseballNumber = baseballNumberGenerator.generate();
        //then
        assertThat(baseballNumber.stream().allMatch(v ->v>=1 && v <=9)).isTrue();
    }
}

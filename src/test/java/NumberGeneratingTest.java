import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratingTest {

    @Test
    void generateRandomNumber() {
        NumberGenerating numberGenerating = new NumberGenerating();
        ArrayList<Integer> result = numberGenerating.generateRandomNumber();
        Assertions.assertThat(result.size())
                .isEqualTo(3);
        for (Integer i : result) {
            System.out.println("i = " + i);
        }
    }
}
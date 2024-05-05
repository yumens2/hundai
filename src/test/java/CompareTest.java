import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import java.util.Arrays;
import java.util.List;

public class CompareTest {
    @Test
    void testGetFeedbackAllStrikes() {
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> player = Arrays.asList(1, 2, 3);
        String result = Compare.getFeedback(computer, player);
        Assertions.assertThat(result).isEqualTo("3 스트라이크");
    }

    @Test
    void testGetFeedbackMixed() {
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> player = Arrays.asList(1, 3, 2);
        String result = Compare.getFeedback(computer, player);
        Assertions.assertThat(result).isEqualTo("1 스트라이크 2 볼");
    }

    @Test
    void testGetFeedbackNothing() {
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> player = Arrays.asList(4, 5, 6);
        String result = Compare.getFeedback(computer, player);
        Assertions.assertThat(result).isEqualTo("낫싱");
    }
}
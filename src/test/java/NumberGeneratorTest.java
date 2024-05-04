import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    private NumberGenerator numberGenerator;
    private SoftAssertions softAssertions;

    private List<Integer> answer;
    private int firstNum;
    private int secondNum;
    private int thirdNum;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
        softAssertions = new SoftAssertions();
        answer = numberGenerator.generateAnswer();
        firstNum = answer.get(0);
        secondNum = answer.get(1);
        thirdNum = answer.get(2);
    }

    @Test
    @DisplayName("정수리스트의 길이는 3이어야만 한다.")
    public void lengthCheck() {

        softAssertions.assertThat(answer.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("리스트 내의 숫자들은 서로 달라야 한다.")
    public void differentEachOther() {

        softAssertions.assertThat(firstNum).isNotEqualTo(secondNum);
        softAssertions.assertThat(firstNum).isNotEqualTo(thirdNum);

        softAssertions.assertThat(secondNum).isNotEqualTo(firstNum);
        softAssertions.assertThat(secondNum).isNotEqualTo(thirdNum);

        softAssertions.assertThat(thirdNum).isNotEqualTo(firstNum);
        softAssertions.assertThat(thirdNum).isNotEqualTo(secondNum);

        softAssertions.assertAll();
    }

    @Test
    @DisplayName("리스트 내의 숫자들은 1~9까지의 숫자여야만 한다.")
    public void rangeCheck() {
        softAssertions.assertThat(firstNum).isBetween(1, 9);
        softAssertions.assertThat(secondNum).isBetween(1, 9);
        softAssertions.assertThat(thirdNum).isBetween(1, 9);
        softAssertions.assertAll();
    }

}

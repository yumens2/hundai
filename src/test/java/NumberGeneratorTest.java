import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

	private NumberGenerator numberGenerator;
	private SoftAssertions softAssertions;

	private List<Integer> answer;

	@BeforeEach
	void setUp() {
		numberGenerator = new NumberGenerator();
		softAssertions = new SoftAssertions();
		answer = numberGenerator.generateAnswer();
	}

	@Test
	@DisplayName("정수리스트의 길이는 3이어야만 한다.")
	public void lengthCheck() {

		softAssertions.assertThat(answer.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("리스트 내의 숫자들은 서로 달라야 한다.")
	public void differentEachOther() {
		int firstNum = answer.get(0);
		int secondNum = answer.get(1);
		int thirdNum = answer.get(2);

		softAssertions.assertThat(firstNum).isNotEqualTo(secondNum);
		softAssertions.assertThat(firstNum).isNotEqualTo(thirdNum);

		softAssertions.assertThat(secondNum).isNotEqualTo(firstNum);
		softAssertions.assertThat(secondNum).isNotEqualTo(thirdNum);

		softAssertions.assertThat(thirdNum).isNotEqualTo(firstNum);
		softAssertions.assertThat(thirdNum).isNotEqualTo(secondNum);

		softAssertions.assertAll();
	}

}

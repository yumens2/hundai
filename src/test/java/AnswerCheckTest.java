import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AnswerCheckTest {

	private AnswerCheck answerCheck;
	private SoftAssertions softAssertions;

	private List<Integer> computerNumber;
	private List<Integer> playerNumber;


	@BeforeEach
	void setUp() throws IOException {
		softAssertions = new SoftAssertions();
	}
	@Nested
	@DisplayName("ball과 strike의 갯수를 정확히 반환하는지 확인")
	class isBallAndStrikeCorrect{

		@Nested
		@DisplayName("ball의 경우에 대해서 확인")
		class isBallCorrect{

			@Test
			@DisplayName("1ball일 경우")
			public void isOneBall(){
				//given
				computerNumber = Arrays.asList(1,2,3);
				playerNumber = Arrays.asList(4,5,1);

				answerCheck = new AnswerCheck(computerNumber,playerNumber);
				Answer result = answerCheck.checkResult(computerNumber,playerNumber);

				softAssertions.assertThat(result.getBall()).isEqualTo(1);
			}

			@Test
			@DisplayName("2ball일 경우")
			public void isTwoBall(){
				//given
				computerNumber = Arrays.asList(1,2,3);
				playerNumber = Arrays.asList(4,3,1);

				answerCheck = new AnswerCheck(computerNumber,playerNumber);
				Answer result = answerCheck.checkResult(computerNumber,playerNumber);

				softAssertions.assertThat(result.getBall()).isEqualTo(2);
			}

			@Test
			@DisplayName("3ball일 경우")
			public void isThreeBall(){
				//given
				computerNumber = Arrays.asList(1,2,3);
				playerNumber = Arrays.asList(2,3,1);

				answerCheck = new AnswerCheck(computerNumber,playerNumber);
				Answer result = answerCheck.checkResult(computerNumber,playerNumber);

				softAssertions.assertThat(result.getBall()).isEqualTo(3);
			}
		}

		@Nested
		@DisplayName("strike의 경우에 대해서 확인")
		class isStrikeCorrect{

			@Test
			@DisplayName("1strike일 경우")
			public void isOneStrike(){
				//given
				computerNumber = Arrays.asList(1,2,3);
				playerNumber = Arrays.asList(1,5,6);

				answerCheck = new AnswerCheck(computerNumber,playerNumber);
				Answer result = answerCheck.checkResult(computerNumber,playerNumber);

				softAssertions.assertThat(result.getStrike()).isEqualTo(1);
			}

			@Test
			@DisplayName("1strike일 경우")
			public void isTwoStrike(){
				//given
				computerNumber = Arrays.asList(1,2,3);
				playerNumber = Arrays.asList(1,2,6);

				answerCheck = new AnswerCheck(computerNumber,playerNumber);
				Answer result = answerCheck.checkResult(computerNumber,playerNumber);

				softAssertions.assertThat(result.getStrike()).isEqualTo(2);
			}

			@Test
			@DisplayName("1strike일 경우")
			public void isThreeStrike(){
				//given
				computerNumber = Arrays.asList(1,2,3);
				playerNumber = Arrays.asList(1,2,3);

				answerCheck = new AnswerCheck(computerNumber,playerNumber);
				Answer result = answerCheck.checkResult(computerNumber,playerNumber);

				softAssertions.assertThat(result.getStrike()).isEqualTo(3);
			}
		}
	}
}

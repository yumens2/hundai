package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class AnswerCheckerTest {

    @Test
    @DisplayName("정답 확인 - strike, ball 테스트")
    void testCheckAnswer() {
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<Integer> userInput = Arrays.asList(1, 4, 2);

        AnswerChecker answerChecker = new AnswerChecker();
        Hint hint = answerChecker.checkAnswer(answer, userInput);

        // 반환된 Hint 객체의 strike, ball 값 확인
        assertThat(hint.getStrike()).isEqualTo(1);
        assertThat(hint.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("게임 종료 확인")
    void testIsFinished() {
        // strike가 DIGIT과 같을 경우 테스트
        Hint hint1 = new Hint();
        hint1.increaseStrike();
        hint1.increaseStrike();
        hint1.increaseStrike();
        assertThat(new AnswerChecker().isFinished(hint1)).isTrue();

        // strike가 DIGIT과 같지 않은 경우 테스트
        Hint hint2 = new Hint();
        hint2.increaseStrike();
        hint2.increaseStrike();
        assertThat(new AnswerChecker().isFinished(hint2)).isFalse();
    }
}
package service;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgeServiceTest {

    private final JudgeService judgeService = new JudgeService();

    @DisplayName("[정답인 경우] 정답인지 체크하고, 아닐 경우 힌트를 제공한다.")
    @Test
    void checkAnswerWithCorrect() throws Exception {
        //given
        int[] numbers = {1, 2, 3};
        int[] answer = {1, 2, 3};

        //when
        boolean isCorrect = judgeService.checkAnswer(numbers, answer);

        //then
        assertThat(isCorrect).isTrue();
    }

    @DisplayName("[정답이 아닌 경우] 정답인지 체크하고, 아닐 경우 힌트를 제공한다.")
    @Test
    void checkAnswerWithIncorrect() throws Exception {
        //given
        int[] numbers = {1, 2, 3};
        int[] answer = {5, 2, 1};

        //when
        boolean isCorrect = judgeService.checkAnswer(numbers, answer);

        //then
        assertThat(isCorrect).isFalse();
    }

}
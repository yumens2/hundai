import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GenerateAnswerTest {

    @Test
    void generateAnswer() {
        Input userInput = new Input();
        GenerateAnswer generateAnswer = new GenerateAnswer();

        for(int i = 0; i < 5000 ; i++){
            assertThat(userInput.isValid(generateAnswer.generateAnswer())).isTrue();
        }

    }
}
package domain;

import static domain.BaseballGame.NUMBER_SIZE;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerPlayerTest {

    private final ComputerPlayer computerPlayer = new ComputerPlayer();

    @Test
    @DisplayName("컴퓨터는 3개의 숫자를 생성한다.")
    public void computerGenerateThreeNumber() {
        //given
        computerPlayer.generateNumbers();

        //when
        int size = computerPlayer.getNumbers().size();

        //then
        assertEquals(NUMBER_SIZE, size);
    }

    @Test
    @DisplayName("컴퓨터가 생성한 숫자는 1에서 9까지의 숫자다.")
    public void validateComputerNumber() {
        //given
        computerPlayer.generateNumbers();

        //when
        boolean isInvalid = computerPlayer.getNumbers().stream()
            .anyMatch(number -> number < BaseballGame.MIN_NUMBER || number > BaseballGame.MAX_NUMBER);

        //then
        assertFalse(isInvalid);
    }
}

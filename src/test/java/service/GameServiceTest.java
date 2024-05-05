package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameServiceTest {
    @Test
    @DisplayName("countBall test")
    void countBallTest() throws Exception {
        //given
        ITestGameService service = new GameService();
        int[] testUserNumbers = {1, 2, 3};
        int[] testComputerNumbers = {3, 2, 1};

        //when
        service.countBall(testUserNumbers, testComputerNumbers);

        //then
        assertThat(service.getBallCount()).isEqualTo(3);
    }

}